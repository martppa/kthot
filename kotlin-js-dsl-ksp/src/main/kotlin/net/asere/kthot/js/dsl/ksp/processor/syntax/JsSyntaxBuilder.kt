package net.asere.kthot.js.dsl.ksp.processor.syntax

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSTypeParameter
import net.asere.kthot.js.dsl.ksp.extension.*
import net.asere.kthot.js.dsl.ksp.processor.*
import java.io.OutputStreamWriter

class JsSyntaxBuilder(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : ClassCodeBuilder {

    private lateinit var jsSyntaxScopeDeclaration: KSClassDeclaration
    private lateinit var jsScopeDeclaration: KSClassDeclaration

    override fun build(resolver: Resolver, declaration: KSClassDeclaration) {
        jsSyntaxScopeDeclaration = resolver.loadClass(jsSyntaxScopeName)
        jsScopeDeclaration = resolver.loadClass(jsScopeName)
        createSyntax(declaration, resolver)
    }

    private fun createSyntax(declaration: KSClassDeclaration, resolver: Resolver) {
        val packageName = declaration.packageName.asString()
        val codeBuilder = StringBuilder()
        if (packageName.isNotBlank()) {
            codeBuilder.append("package $packageName\n\n")
        }
        codeBuilder.appendImports(declaration, resolver)
        val className = declaration.jsName + "Syntax"
        codeBuilder.append("class $className${declaration.genericTypesDeclarationString()} @JsInternalApi constructor(\n")
        codeBuilder.append("  value: String${declaration.getComma(resolver)}\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  override val ${type.getBuilderDefinition(resolver.loadClass(jsElementName))},\n")
        }
        codeBuilder.append(") : ${resolver.loadClass(jsReferenceSyntaxName)}<${declaration.jsName}${declaration.genericTypesNamesString}>(value), ${declaration.jsName}${declaration.genericTypesNamesString}${declaration.whereClauseString} {\n")
        codeBuilder.append(
            "   @JsInternalApi constructor(value: ${resolver.loadClass(jsElementName).name}${
                declaration.getComma(
                    resolver
                )
            } "
        )
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("${type.getBuilderDefinition(resolver.loadClass(jsElementName))},")
        }
        codeBuilder.append(") : this(")
        codeBuilder.append($$$"\"$value\"$$${declaration.getComma(resolver)}")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("${type.builderName}, ")
        }
        codeBuilder.append(")\n")
        codeBuilder.append("}\n\n")

        if (declaration.typeParameters.isNotEmpty() && declaration.getGenericReturnTypes(resolver).isNotEmpty()) {
            codeBuilder.append("@OptIn(JsInternalApi::class)\n")
            codeBuilder.append("inline fun ${declaration.genericTypesDeclarationString("reified")} ${declaration.jsName}.Companion.syntax(\n")
            codeBuilder.append("  value: String")
            codeBuilder.append("  \n")
            codeBuilder.append("): ${declaration.jsName}${declaration.genericTypesNamesString}${declaration.whereClauseString}")
            codeBuilder.append(" = ")
            codeBuilder.append("$className(")
            codeBuilder.append("value${declaration.getComma(resolver)}")
            declaration.getGenericReturnTypes(resolver).joinToString { item -> "::provide" }.let {
                codeBuilder.append(it)
            }
            codeBuilder.append(")\n\n")

            codeBuilder.append("@OptIn(JsInternalApi::class)\n")
            codeBuilder.append("inline fun ${declaration.genericTypesDeclarationString("reified")} ${declaration.jsName}.Companion.syntax(\n")
            codeBuilder.append("  value: JsElement")
            codeBuilder.append("  \n")
            codeBuilder.append("): ${declaration.jsName}${declaration.genericTypesNamesString}${declaration.whereClauseString}")
            codeBuilder.append(" = ")
            codeBuilder.append("$className(")
            codeBuilder.append("value${declaration.getComma(resolver)}")
            declaration.getGenericReturnTypes(resolver).joinToString { item -> "::provide" }.let {
                codeBuilder.append(it)
            }
            codeBuilder.append(")\n")

            codeBuilder.append("inline fun ${declaration.genericTypesDeclarationString("reified")} ${declaration.jsName}.Companion.syntax(\n")
            codeBuilder.append("  block: ${jsScopeDeclaration.name}.() -> ${declaration.parametrizedName}")
            codeBuilder.append("  \n")
            codeBuilder.append("): ${declaration.parametrizedName} {\n")
            codeBuilder.append("    val scope = ${jsSyntaxScopeDeclaration.name}()\n")
            codeBuilder.append("    scope.block()\n")
            codeBuilder.append("    return syntax(scope)\n")
            codeBuilder.append("}\n")

            codeBuilder.append("\n")
            val constructor = declaration.findJsConstructors().firstOrNull()
            if (constructor != null) {
                codeBuilder.append(
                    "inline fun ${declaration.genericTypesDeclarationString(modifier = "reified")} ${declaration.jsName}.Companion.new(${
                    constructor.parametersDefinitionBasicString
                }): ${declaration.jsName}${declaration.genericTypesNamesString} = ${declaration.jsName}.syntax${declaration.genericTypesNamesString}(JsSyntax(\"new ${declaration.jsName}(${constructor.parametersNames.joinToString { "$$it" }})\"))"
                )
            } else {
                codeBuilder.append("inline fun ${declaration.genericTypesDeclarationString(modifier = "reified")} ${declaration.jsName}.Companion.new(): ${declaration.jsName}${declaration.genericTypesNamesString} = ${declaration.jsName}.syntax${declaration.genericTypesNamesString}(JsSyntax(\"new ${declaration.jsName}()\"))")
            }
        } else {
            codeBuilder.append("fun ${declaration.jsName}.Companion.syntax(\n")
            codeBuilder.append("  block: ${jsScopeDeclaration.name}.() -> ${declaration.jsName}")
            codeBuilder.append("  \n")
            codeBuilder.append("): ${declaration.jsName} {\n")
            codeBuilder.append("    val scope = ${jsSyntaxScopeDeclaration.name}()\n")
            codeBuilder.append("    scope.block()\n")
            codeBuilder.append("    return syntax(scope)\n")
            codeBuilder.append("}\n")

            codeBuilder.append("\n")
            val constructor = declaration.findJsConstructors().firstOrNull()
            if (constructor != null) {
                declaration.findJsConstructors().firstOrNull()?.let { constructor ->
                    codeBuilder.append(
                        "fun ${declaration.jsName}.Companion.new(${
                            constructor.parametersDefinitionBasicString
                        }): ${declaration.jsName} = ${declaration.jsName}.syntax(JsSyntax(\"new ${declaration.jsName}(${constructor.parametersNames.joinToString { "$$it" }})\"))"
                    )
                }
            } else {
                codeBuilder.append(
                    "fun ${declaration.jsName}.Companion.new(): ${declaration.jsName} = ${declaration.jsName}.syntax(JsSyntax(\"new ${declaration.jsName}()\"))"
                )
            }
        }

        codeBuilder.append("\n\n")
        codeBuilder.append("@OptIn(JsInternalApi::class)\n")
        codeBuilder.append("fun ${declaration.genericTypesDeclarationString()} ${declaration.jsName}.Companion.syntax(\n")
        codeBuilder.append("  value: ${resolver.loadClass(jsElementName)}${declaration.getComma(resolver)}\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  ${type.getBuilderDefinition(resolver.loadClass(jsElementName))},\n")
        }
        codeBuilder.append("): ${declaration.jsName}${declaration.genericTypesNamesString} ${declaration.whereClauseString}")
        codeBuilder.append(" = ")
        codeBuilder.append("$className(")
        codeBuilder.append("value${declaration.getComma(resolver)}")
        declaration.getGenericReturnTypes(resolver).joinToString { item -> item.builderName }.let {
            codeBuilder.append(it)
        }

        codeBuilder.append(")\n\n")

        codeBuilder.append("@OptIn(JsInternalApi::class)\n")
        codeBuilder.append("fun ${declaration.genericTypesDeclarationString()} ${declaration.jsName}.Companion.syntax(\n")
        codeBuilder.append("  value: String${declaration.getComma(resolver)}\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  ${type.getBuilderDefinition(resolver.loadClass(jsElementName))},\n")
        }
        codeBuilder.append("): ${declaration.jsName}${declaration.genericTypesNamesString}${declaration.whereClauseString}")
        codeBuilder.append(" = ")
        codeBuilder.append("$className(")
        codeBuilder.append("value${declaration.getComma(resolver)}")
        declaration.getGenericReturnTypes(resolver).joinToString { item -> item.builderName }.let {
            codeBuilder.append(it)
        }
        codeBuilder.append(")\n\n")

        writeToFile(
            fileName = className,
            packageName = packageName,
            declaration = declaration,
            codeBuilder = codeBuilder
        )
    }

    private fun StringBuilder.appendImports(declaration: KSClassDeclaration, resolver: Resolver) {
        val imports: MutableSet<String> = mutableSetOf()

        imports.add(resolver.loadClass(jsReferenceSyntaxName).fullName)
        imports.add(resolver.loadClass(jsInternalApiAnnotationName).fullName)
        imports.add(resolver.loadClass(jsElementName).fullName)
        imports.add(resolver.loadClass(jsSyntaxName).fullName)
        imports.add(resolver.loadClass(jsSyntaxScopeName).fullName)
        imports.add(resolver.loadClass(jsScopeName).fullName)
        imports.add(jsProvideFunctionName)
        declaration.getAllTypes().forEach {
            imports.add(it.declaration.fullName)
        }
        declaration.findJsConstructors().forEach { constructor ->
            constructor.parameters.forEach { parameter ->
                if (!parameter.type.isGenericTypeParameter())
                    imports.add(parameter.type.resolve().declaration.fullJsName)
            }
        }
        declaration.getJsAvailableProperties(resolver)
            .filter { it.type.resolve().declaration !is KSTypeParameter }
            .forEach { property ->
                imports.add(property.typeFullName)
                imports.add(property.basicTypeFullName)
            }
        for (function in declaration.getJsAvailableFunctions(resolver)) {
            if (function.returnType?.resolve() !is KSTypeParameter) {
                imports.add(function.returnType!!.resolve().declaration.fullName)
                imports.add(function.returnType!!.resolve().declaration.fullBasicTypeName)
            }
            function.parameters.filter { it.type.resolve() !is KSTypeParameter }.forEach { param ->
                imports.add(param.type.resolve().declaration.fullName)
                imports.add(param.type.resolve().declaration.fullBasicTypeName)
            }
        }
        imports.remove("kotlin.Any")
        imports.forEach {
            append("import $it\n")
        }
        append("\n")
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
            extensionName = "kt"
        )
        OutputStreamWriter(file).use { it.write(codeBuilder.toString()) }
    }
}

private fun KSClassDeclaration.getComma(resolver: Resolver) =
    if (getGenericReturnTypes(resolver).isNotEmpty()) "," else ""