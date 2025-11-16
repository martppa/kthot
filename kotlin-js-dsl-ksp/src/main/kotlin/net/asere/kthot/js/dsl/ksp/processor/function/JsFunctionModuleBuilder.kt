package net.asere.kthot.js.dsl.ksp.processor.function

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSTypeParameter
import net.asere.kthot.js.dsl.ksp.extension.*
import net.asere.kthot.js.dsl.ksp.processor.*
import java.io.OutputStreamWriter

class JsFunctionModuleBuilder(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
) : ClassCodeBuilder {
    private lateinit var jsChainOperationDeclaration: KSClassDeclaration
    private lateinit var jsInvocationOperationDeclaration: KSClassDeclaration
    private lateinit var jsObjectDeclaration: KSClassDeclaration
    private lateinit var jsSyntaxDeclaration: KSClassDeclaration
    private lateinit var jsReferenceDeclaration: KSClassDeclaration
    private lateinit var jsElementDeclaration: KSClassDeclaration
    private lateinit var jsAccessOperationDeclaration: KSClassDeclaration
    private lateinit var jsInternalApiAnnotationDeclaration: KSClassDeclaration
    private lateinit var jsImportableAnnotationDeclaration: KSClassDeclaration

    private fun Resolver.checkDependencies() {
        jsChainOperationDeclaration = loadClass(jsChainOperationName)
        jsInvocationOperationDeclaration = loadClass(jsInvocationOperationName)
        jsObjectDeclaration = loadClass(jsObjectName)
        jsSyntaxDeclaration = loadClass(jsSyntaxName)
        jsReferenceDeclaration = loadClass(jsReferenceName)
        jsElementDeclaration = loadClass(jsElementName)
        jsAccessOperationDeclaration = loadClass(jsAccessOperationName)
        jsInternalApiAnnotationDeclaration = loadClass(jsInternalApiAnnotationName)
        jsImportableAnnotationDeclaration = loadClass(jsImportableAnnotationName)
    }

    override fun build(resolver: Resolver, declaration: KSClassDeclaration) {
        resolver.checkDependencies()
        val packageName = declaration.packageName.asString()
        val codeBuilder = StringBuilder()
        if (packageName.isNotBlank()) {
            codeBuilder.append("package $packageName\n\n")
        }
        codeBuilder.appendImports(declaration, resolver)
        val interfaceName = declaration.jsName
        codeBuilder.append("@${jsImportableAnnotationDeclaration.name}\n")
        codeBuilder.append("interface $interfaceName {\n")
        codeBuilder.append("    companion object {\n")
        if (!declaration.isApi) {
            codeBuilder.append(
                "       val Module = ${declaration.jsName}Module()\n"
            )
        }
        codeBuilder.appendMethods(declaration, resolver)
        codeBuilder.append("    }\n")
        codeBuilder.append("}\n")
        writeToFile(
            fileName = interfaceName,
            packageName = packageName,
            declaration = declaration,
            codeBuilder = codeBuilder
        )
    }

    private fun StringBuilder.appendImports(declaration: KSClassDeclaration, resolver: Resolver) {
        val imports: MutableSet<String> = mutableSetOf()
        imports.add(resolver.loadClass(jsElementName).fullName)
        imports.add(jsChainOperationDeclaration.fullName)
        imports.add(jsInvocationOperationDeclaration.fullName)
        imports.add(jsAccessOperationDeclaration.fullName)
        imports.add(jsInternalApiAnnotationDeclaration.fullName)
        imports.add(jsImportableAnnotationDeclaration.fullName)
        imports.add(jsProvideFunctionName)
        if (!declaration.isApi) {
            imports.add("${declaration.packageName.asString()}.${declaration.jsName}Module")
        }
        declaration.getAllTypes().forEach {
            imports.add(it.declaration.fullName)
        }
        declaration.getGenericReturnTypes(resolver).filter { !it.isGenericType }.forEach { type ->
            imports.add(type.declaration.fullName)
        }
        for (function in declaration.getJsAvailableFunctions(resolver)) {
            function.typeParameters
                .map { type ->
                    type.bounds.toList().map {
                        it.resolve().getAllTypes()
                    }
                }.flatten().flatten().map { it.declaration.fullName }.forEach {
                    imports.add(it)
                }
            if (function.returnType != null && !function.returnType!!.isGenericTypeParameter()) {
                imports.add(function.returnType!!.resolve().declaration.fullName)
                imports.add(function.returnType!!.resolve().declaration.fullBasicTypeName)
                function.returnType!!.resolve().getAllTypes().filter { !it.isGenericType }
                    .forEach { imports.add(it.declaration.fullName) }
                if (!function.returnType.isSubclassOf(jsSyntaxDeclaration)) {
                    imports.add("${function.returnType!!.packageName}.syntax")
                }
                if (function.returnType.isSubclassOf(jsReferenceDeclaration) &&
                    function.returnType!!.resolve().declaration.fullJsName != jsNothingName) {
                    imports.add("${function.returnType!!.packageName}.ref")
                }
            }
            function.parameters.filter { it.type.resolve() !is KSTypeParameter }.forEach { param ->
                if (!param.type.isGenericTypeParameter()) {
                    imports.add(param.type.resolve().declaration.fullName)
                    imports.add(param.type.resolve().declaration.fullBasicTypeName)
                }
            }
        }
        imports.remove("kotlin.Any")
        imports.forEach {
            append("import $it\n")
        }
        append("\n")
    }

    private fun StringBuilder.appendMethods(declaration: KSClassDeclaration, resolver: Resolver) {
        declaration.getJsAvailableFunctions(resolver).forEach { function ->
            val functionName = function.name
            if (function.returnType.isGenericTypeParameter()) {
                append("  inline fun ${function.getDeclaration(functionName)}(${
                    function.parameters.definitionString()}): ${
                    function.returnType?.resolve()?.definitionName}${function.whereClauseString} = provide(${
                    jsInvocationOperationDeclaration.name}(\"$functionName\", ${
                    function.parameters.listString()}))\n")
            } else if (function.returnType?.resolve().hasArgumentsTypes()) {
                val builderParameters = function.returnType!!.resolve().getArgumentsTypes()
                append("  inline fun ${function.getDeclaration(functionName)}(${
                    function.parameters.definitionString()}): ${
                    function.returnType?.resolve()?.definitionName}${function.whereClauseString} = ${
                    function.returnType?.resolve()?.declaration?.name}.syntax(${
                    jsInvocationOperationDeclaration.name
                }(\"$functionName\", ${
                    function.parameters.listString()
                }), ${
                    builderParameters.joinToString(
                        ", "
                    ) { "::provide" }
                })\n")
            } else {
                append("  inline fun ${function.getDeclaration(functionName)}(${
                    function.parameters.definitionString()}): ${
                    function.returnType?.resolve()?.definitionName}${function.whereClauseString} = ${
                    function.returnType?.resolve()?.declaration?.name}.syntax(${
                    jsInvocationOperationDeclaration.name}(\"$functionName\", ${
                    function.parameters.listString()}))\n")
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

private fun KSFunctionDeclaration.getDeclaration(name: String? = null): String {
    val stringBuilder = StringBuilder()
    val genericTypes = mutableListOf<String>()
    typeParameters.forEach { parameter ->
        val bounds = parameter.bounds.filter { !it.resolve().declaration.isAny() }.toList()
        when (bounds.size) {
            1 -> genericTypes.add("reified ${parameter.name.asString()} : ${bounds.first().resolve().definitionName}")
            else -> genericTypes.add(parameter.name.asString())
        }
    }
    if (genericTypes.isNotEmpty()) {
        stringBuilder.append("<")
        stringBuilder.append(genericTypes.joinToString(", "))
        stringBuilder.append("> ")
    }
    stringBuilder.append(name ?: this.name)

    return stringBuilder.toString()
}