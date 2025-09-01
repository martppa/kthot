package net.asere.kotlin.js.dsl.ksp.processor.intf

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSTypeParameter
import net.asere.kotlin.js.dsl.ksp.extension.*
import net.asere.kotlin.js.dsl.ksp.processor.*
import java.io.OutputStreamWriter

class JsInterfaceBuilder(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
) : CodeBuilder {
    private lateinit var jsChainOperationDeclaration: KSClassDeclaration
    private lateinit var jsInvocationOperationDeclaration: KSClassDeclaration
    private lateinit var jsObjectDeclaration: KSClassDeclaration
    private lateinit var jsSyntaxDeclaration: KSClassDeclaration
    private lateinit var jsElementDeclaration: KSClassDeclaration
    private lateinit var jsAccessOperationDeclaration: KSClassDeclaration

    override fun build(resolver: Resolver, declaration: KSClassDeclaration) {
        resolver.checkDependencies()
        val packageName = declaration.packageName.asString()
        val codeBuilder = StringBuilder()
        if (packageName.isNotBlank()) {
            codeBuilder.append("package $packageName\n\n")
        }
        codeBuilder.appendImports(declaration, resolver)
        val interfaceName = declaration.jsName
        codeBuilder.append("interface ${declaration.getDeclaration(interfaceName)} {\n")
        codeBuilder.appendProperties(declaration, resolver)
        codeBuilder.appendMethods(declaration, resolver)
        codeBuilder.appendCompanion(declaration)
        codeBuilder.append("}\n")
        writeToFile(
            fileName = interfaceName,
            packageName = packageName,
            declaration = declaration,
            codeBuilder = codeBuilder
        )
    }

    private fun StringBuilder.appendCompanion(declaration: KSClassDeclaration) {
        append("\n")
        append("   companion object {\n")
        append("       const val Source = \"${declaration.packageName.asString().replace(".", "/")}/${declaration.jsName}.js\"\n")
        append("   }\n")
    }

    private fun Resolver.checkDependencies() {
        jsChainOperationDeclaration = loadClass(jsChainOperationName)
        jsInvocationOperationDeclaration = loadClass(jsInvocationOperationName)
        jsObjectDeclaration = loadClass(jsObjectName)
        jsSyntaxDeclaration = loadClass(jsSyntaxName)
        jsElementDeclaration = loadClass(jsElementName)
        jsAccessOperationDeclaration = loadClass(jsAccessOperationName)
    }

    private fun StringBuilder.appendImports(declaration: KSClassDeclaration, resolver: Resolver) {
        val imports: MutableSet<String> = mutableSetOf()
        imports.add(resolver.loadClass(jsElementName).fullName)
        imports.add(jsChainOperationDeclaration.fullName)
        imports.add(jsInvocationOperationDeclaration.fullName)
        imports.add(jsAccessOperationDeclaration.fullName)
        if (declaration.getGenericReturnTypes(resolver).isNotEmpty()) {
            imports.add(jsElementDeclaration.fullName)
        }
        declaration.superTypeInterfaces.forEach { type ->
            imports.addAll(type.getAllTypes().map { it.declaration.fullName })
        }
        declaration.constructors.forEach { constructor ->
            constructor.parameters.forEach { parameter ->
                imports.add(parameter.type.resolve().declaration.fullName)
            }
        }
        declaration.getJsAvailableProperties(resolver)
            .filter { it.type.resolve().declaration !is KSTypeParameter }
            .forEach { property ->
                imports.add(property.typeFullName)
                if (!property.isTypeSubclassOf(jsSyntaxDeclaration)) {
                    imports.add("${property.typePackage}.syntax")
                }
            }
        if (declaration.superTypeInterfaces.isEmpty()) {
            imports.add(jsObjectDeclaration.fullName)
        } else {
            declaration.superTypeInterfaces.forEach {
                imports.add(it.declaration.fullName)
            }
        }
        for (function in declaration.getJsAvailableFunctions(resolver)) {
            if (function.returnType?.resolve() !is KSTypeParameter) {
                imports.add(function.returnType!!.resolve().declaration.fullName)
                if (!function.returnType.isSubclassOf(jsSyntaxDeclaration)) {
                    imports.add("${function.returnType!!.packageName}.syntax")
                }
            }
            function.parameters.filter { it.type.resolve() !is KSTypeParameter }.forEach { param ->
                imports.add(param.type.resolve().declaration.fullName)
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
            val propertyName = property.name
            val propertyDefinitionName = property.type.resolve().definitionName
            val propertyTypeSimpleName = property.type.resolve().declaration.name
            if (property.isGenericTypeParameter()) {
                append("  val $propertyName: $propertyDefinitionName get() = ${property.type.resolve().builderName}(${resolver.loadClass(jsAccessOperationName)}(this, \"$propertyName\"), ${property.type.isNullable()})")
            } else if (property.hasArgumentsTypes()) {
                val builderParameters = property.getArgumentsTypes()
                append("  val $propertyName: $propertyDefinitionName get() = $propertyTypeSimpleName.syntax(${
                    builderParameters.joinToString(
                        ", "
                    ) { it.builderName }
                }, ${jsChainOperationDeclaration.name}(this, \"$propertyName\"))\n")
            } else {
                append("  val $propertyName: $propertyDefinitionName get() = $propertyDefinitionName.syntax(${jsChainOperationDeclaration.name}(this, \"$propertyName\"))\n")
            }
        }
    }

    private fun StringBuilder.appendMethods(declaration: KSClassDeclaration, resolver: Resolver) {
        declaration.getJsAvailableFunctions(resolver).forEach { function ->
            val functionName = function.name
            if (function.returnType.isGenericTypeParameter()) {
                append("  fun $functionName(${
                    function.parameters.definitionString()}): ${
                        function.returnType?.resolve()?.definitionName} = ${
                            function.returnType?.resolve()?.builderName}(${
                                resolver.loadClass(jsAccessOperationName)}(this, ${
                                    jsInvocationOperationDeclaration.name}(\"$functionName\", ${
                                        function.parameters.listString()})), ${function.returnType.isNullable()})")
            } else if (function.returnType?.resolve().hasArgumentsTypes()) {
                val builderParameters = function.returnType!!.resolve().getArgumentsTypes()
                append("  fun $functionName(${
                    function.parameters.definitionString()}): ${
                        function.returnType?.resolve()?.definitionName} = ${
                            function.returnType?.resolve()?.declaration?.name}.syntax(${
                    builderParameters.joinToString(
                        ", "
                    ) { it.builderName }
                }, ${jsChainOperationDeclaration.name}(this, ${
                    jsInvocationOperationDeclaration.name}(\"$functionName\", ${
                        function.parameters.listString()})))\n")
            } else {
                append("  fun $functionName(${
                    function.parameters.definitionString()}): ${
                        function.returnType?.resolve()?.definitionName} = ${
                            function.returnType?.resolve()?.declaration?.name}.syntax(${
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

private fun KSClassDeclaration.getDeclaration(name: String? = null): String {
    val stringBuilder = StringBuilder()
    stringBuilder.append(name ?: this.name)
    val genericTypes = mutableListOf<String>()
    typeParameters.forEach { parameter ->
        val bounds = parameter.bounds.filter { !it.resolve().declaration.isAny() }.toList()
        when (bounds.size) {
            1 -> genericTypes.add("${parameter.name.asString()} : ${bounds.first().resolve().definitionName}")
            else -> genericTypes.add(parameter.name.asString())
        }
    }
    if (genericTypes.isNotEmpty()) {
        stringBuilder.append("<")
        stringBuilder.append(genericTypes.joinToString(", "))
        stringBuilder.append(">")
    }
    stringBuilder.append(" : ")
    val superTypes = superTypeInterfaces
    stringBuilder.append(
        if (superTypes.isNotEmpty()) superTypes.joinToString(", ") { it.definitionName } else "JsObject"
    )

    stringBuilder.append(" $whereClauseString")

    return stringBuilder.toString()
}