package net.asere.kthot.js.dsl.ksp.processor.intf

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSTypeParameter
import net.asere.kthot.js.dsl.ksp.extension.*
import net.asere.kthot.js.dsl.ksp.processor.*
import java.io.OutputStreamWriter

abstract class JsInterfaceBuilder(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
) : ClassCodeBuilder {
    protected lateinit var jsChainOperationDeclaration: KSClassDeclaration
    protected lateinit var jsInvocationOperationDeclaration: KSClassDeclaration
    protected lateinit var jsObjectDeclaration: KSClassDeclaration
    protected lateinit var jsSyntaxDeclaration: KSClassDeclaration
    protected lateinit var jsReferenceDeclaration: KSClassDeclaration
    protected lateinit var jsElementDeclaration: KSClassDeclaration
    protected lateinit var jsAccessOperationDeclaration: KSClassDeclaration
    protected lateinit var jsInternalApiAnnotationDeclaration: KSClassDeclaration
    protected lateinit var jsImportableAnnotationDeclaration: KSClassDeclaration

    protected open fun StringBuilder.appendHeader(declaration: KSClassDeclaration) {
        append("@OptIn(${jsInternalApiAnnotationDeclaration.name}::class)\n")
        append("@${jsImportableAnnotationDeclaration.name}\n")
        append("interface ${declaration.getDeclaration(declaration.jsName)} {\n")
    }

    protected abstract fun getModuleClass(resolver: Resolver): KSClassDeclaration

    override fun build(resolver: Resolver, declaration: KSClassDeclaration) {
        resolver.checkDependencies()
        val packageName = declaration.packageName.asString()
        val codeBuilder = StringBuilder()
        if (packageName.isNotBlank()) {
            codeBuilder.append("package $packageName\n\n")
        }
        codeBuilder.appendImports(declaration, resolver)
        codeBuilder.appendHeader(declaration)
        codeBuilder.appendProperties(declaration, resolver)
        codeBuilder.appendMethods(declaration, resolver)
        codeBuilder.appendCompanion(resolver, declaration)
        codeBuilder.append("}\n")
        writeToFile(
            fileName = declaration.jsName,
            packageName = packageName,
            declaration = declaration,
            codeBuilder = codeBuilder
        )
    }

    protected abstract fun StringBuilder.appendCompanion(resolver: Resolver, declaration: KSClassDeclaration)

    protected abstract fun getImportPath(declaration: KSClassDeclaration): String?

    private fun Resolver.checkDependencies() {
        jsChainOperationDeclaration = loadClass(jsChainOperationName)
        jsInvocationOperationDeclaration = loadClass(jsInvocationOperationName)
        jsObjectDeclaration = loadClass(jsObjectName)
        jsSyntaxDeclaration = loadClass(jsSyntaxName)
        jsReferenceDeclaration = loadClass(jsSyntaxName)
        jsElementDeclaration = loadClass(jsElementName)
        jsAccessOperationDeclaration = loadClass(jsAccessOperationName)
        jsInternalApiAnnotationDeclaration = loadClass(jsInternalApiAnnotationName)
        jsImportableAnnotationDeclaration = loadClass(jsImportableAnnotationName)
    }

    private fun StringBuilder.appendImports(declaration: KSClassDeclaration, resolver: Resolver) {
        val imports: MutableSet<String> = mutableSetOf()
        imports.add(resolver.loadClass(jsElementName).fullName)
        imports.add(getModuleClass(resolver).fullName)
        imports.add(jsChainOperationDeclaration.fullName)
        imports.add(jsInvocationOperationDeclaration.fullName)
        imports.add(jsAccessOperationDeclaration.fullName)
        imports.add(jsInternalApiAnnotationDeclaration.fullName)
        imports.add(jsImportableAnnotationDeclaration.fullName)
        imports.add(jsProvideFunctionName)
        declaration.getGenericReturnTypes(resolver).filter { !it.isGenericType }.forEach { type ->
            imports.add(type.declaration.fullName)
        }
        if (declaration.getGenericReturnTypes(resolver).isNotEmpty()) {
            imports.add(jsElementDeclaration.fullName)
        }
        declaration.superTypeInterfaces.forEach { type ->
            imports.addAll(type.getAllTypes().map { it.declaration.fullName })
        }
        declaration.constructors.forEach { constructor ->
            constructor.parameters.forEach { parameter ->
                imports.add(parameter.type.resolve().declaration.fullName)
                imports.add(parameter.type.resolve().declaration.fullBasicTypeName)
            }
        }
        declaration.getJsAvailableProperties(resolver)
            .filter { it.type.resolve().declaration !is KSTypeParameter }
            .forEach { property ->
                imports.add(property.typeFullName)
                imports.add(property.basicTypeFullName)
                if (!property.isTypeSubclassOf(jsSyntaxDeclaration)) {
                    imports.add("${property.typePackage}.syntax")
                }
                if (!property.isTypeSubclassOf(jsReferenceDeclaration)) {
                    imports.add("${property.typePackage}.ref")
                }
            }
        if (declaration.superTypeInterfaces.isEmpty()) {
            imports.add(jsObjectDeclaration.fullName)
        } else {
            declaration.superTypeInterfaces.forEach {
                imports.add(it.declaration.fullName)
                imports.add(it.declaration.fullBasicTypeName)
            }
        }
        for (function in declaration.getJsAvailableFunctions(resolver)) {
            if (function.returnType?.resolve() !is KSTypeParameter) {
                imports.add(function.returnType!!.resolve().declaration.fullName)
                imports.add(function.returnType!!.resolve().declaration.fullBasicTypeName)
                if (!function.returnType.isSubclassOf(jsSyntaxDeclaration)) {
                    imports.add("${function.returnType!!.packageName}.syntax")
                }
                if (!function.returnType.isSubclassOf(jsReferenceDeclaration)) {
                    imports.add("${function.returnType!!.packageName}.ref")
                }
            }
            function.parameters.filter { it.type.resolve() !is KSTypeParameter }.forEach { param ->
                imports.add(param.type.resolve().declaration.fullName)
                imports.add(param.type.resolve().declaration.fullBasicTypeName)
            }
        }
        declaration.typeParameters
            .map { type ->
                type.bounds.toList().map {
                    it.resolve().getAllTypes()
                }
            }.flatten().flatten().map { it.declaration.fullName }.forEach {
                imports.add(it)
            }
        imports.remove("kotlin.Any")
        imports.forEach {
            append("import $it\n")
        }
        append("\n")
    }

    private fun StringBuilder.appendProperties(declaration: KSClassDeclaration, resolver: Resolver) {
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            append("  val ${type.getBuilderDefinition(jsElementDeclaration)}\n")
        }
        declaration.getJsAvailableProperties(resolver).forEach { property ->
            if (property.type.isSubclassOf(jsSyntaxDeclaration))
                throw IllegalArgumentException("Properties of generated classes can't be of type JsSyntax")
            val propertyName = property.name
            val propertyDefinitionName = property.type.resolve().definitionName
            if (property.isGenericTypeParameter()) {
                append(
                    "  val $propertyName: $propertyDefinitionName get() = ${property.type.resolve().builderName}(${
                        resolver.loadClass(
                            jsAccessOperationName
                        )
                    }(this, \"$propertyName\"))\n"
                )
            } else {
                val builderParameters = property.type.resolve().getArgumentsTypes()
                append("  val $propertyName: $propertyDefinitionName get() = ${property.type.resolve().declaration.basicJsName}.ref(${jsChainOperationDeclaration.name}(this, \"$propertyName\"), ${
                    builderParameters.joinToString(
                        ", "
                    ) { if (it.isGenericType) it.builderName else "::provide" }
                })\n")
            }
        }
    }

    private fun StringBuilder.appendMethods(declaration: KSClassDeclaration, resolver: Resolver) {
        declaration.getJsAvailableFunctions(resolver).forEach { function ->
            val syntaxInvocationString: String = if (function.returnType?.resolve()?.declaration?.fullName == jsSyntaxName) "" else ".syntax"
            val functionName = function.name
            if (function.returnType.isGenericTypeParameter()) {
                append("  fun $functionName(${
                    function.parameters.definitionString()}): ${
                        function.returnType?.resolve()?.definitionName} = ${
                            function.returnType?.resolve()?.builderName}(${
                                resolver.loadClass(jsAccessOperationName)}(this, ${
                                    jsInvocationOperationDeclaration.name}(\"$functionName\", ${
                                        function.parameters.listString()})))")
            } else if (function.returnType?.resolve().hasArgumentsTypes()) {
                val builderParameters = function.returnType!!.resolve().getArgumentsTypes()
                append("  fun $functionName(${
                    function.parameters.definitionString()}): ${
                        function.returnType?.resolve()?.definitionName} = ${
                            function.returnType?.resolve()?.declaration?.name}$syntaxInvocationString(${
                                jsChainOperationDeclaration.name}(this, ${
                    jsInvocationOperationDeclaration.name}(\"$functionName\", ${
                        function.parameters.listString()})), ${
                    builderParameters.joinToString(
                        ", "
                    ) { if (it.isGenericType) it.builderName else "::provide" }
                })\n")
            } else if (function.returnType?.resolve()?.declaration.isJsElement(resolver)) {
                append("  fun $functionName(${
                    function.parameters.definitionString()}): ${
                        function.returnType?.resolve()?.definitionName} = ${
                            function.returnType?.resolve()?.declaration?.name}$syntaxInvocationString(${
                                jsChainOperationDeclaration.name}(this, ${
                                    jsInvocationOperationDeclaration.name}(\"$functionName\", ${
                                        function.parameters.listString()})))\n")
            }
        }
    }

    private fun writeToFile(
        fileName: String,
        packageName: String,
        declaration: KSClassDeclaration,
        codeBuilder: StringBuilder
    ) {
        val file = codeGenerator.createNewFile(
            dependencies = Dependencies(false, declaration.containingFile!!),
            packageName = packageName,
            fileName = fileName,
            extensionName = "kt",
        )
        OutputStreamWriter(file).use { it.write(codeBuilder.toString()) }
    }
}