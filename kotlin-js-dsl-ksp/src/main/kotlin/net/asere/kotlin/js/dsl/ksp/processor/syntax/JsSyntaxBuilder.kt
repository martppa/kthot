package net.asere.kotlin.js.dsl.ksp.processor.syntax

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import net.asere.kotlin.js.dsl.ksp.extension.*
import net.asere.kotlin.js.dsl.ksp.processor.CodeBuilder
import net.asere.kotlin.js.dsl.ksp.processor.jsElementName
import net.asere.kotlin.js.dsl.ksp.processor.jsReferenceSyntaxName
import java.io.OutputStreamWriter

class JsSyntaxBuilder(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : CodeBuilder {

    override fun build(resolver: Resolver, declaration: KSClassDeclaration) {
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
        codeBuilder.append("class $className${declaration.genericTypesDeclarationString} internal constructor(\n")
        codeBuilder.append("  value: String,\n")
        codeBuilder.append("  isNullable: Boolean,")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  override val ${type.getBuilderDefinition(resolver.loadClass(jsElementName))},\n")
        }
        codeBuilder.append("\n) : ${resolver.loadClass(jsReferenceSyntaxName)}<${declaration.jsName}${declaration.genericTypesString}>(value, isNullable), ${declaration.jsName}${declaration.genericTypesString}${declaration.whereClauseString} {\n")
        codeBuilder.append("   internal constructor(value: ${resolver.loadClass(jsElementName).name}, isNullable: Boolean, ")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("${type.getBuilderDefinition(resolver.loadClass(jsElementName))},")
        }
        codeBuilder.append(") : this(")
        codeBuilder.append($$$"\"$value\", ")
        codeBuilder.append("isNullable, ")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("${type.builderName}, ")
        }
        codeBuilder.append(")\n")
        codeBuilder.append("}\n\n")

        codeBuilder.append("fun ${declaration.genericTypesDeclarationString} ${declaration.jsName}.Companion.syntax(\n")
        codeBuilder.append("  value: String,\n")
        codeBuilder.append("  isNullable: Boolean = false,\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  ${type.getBuilderDefinition(resolver.loadClass(jsElementName))},\n")
        }
        codeBuilder.append("): ${declaration.jsName}${declaration.genericTypesString}${declaration.whereClauseString}")
        codeBuilder.append(" = ")
        codeBuilder.append("$className(")
        codeBuilder.append("value, ")
        codeBuilder.append("isNullable, ")
        declaration.getGenericReturnTypes(resolver).joinToString { item -> "${item.declaration.name.replaceFirstChar { it.lowercase() }}Builder" }.let {
            codeBuilder.append(it)
        }
        codeBuilder.append(")\n\n")

        codeBuilder.append("fun ${declaration.genericTypesDeclarationString} ${declaration.jsName}.Companion.syntax(\n")
        codeBuilder.append("  value: ${resolver.loadClass(jsElementName)},\n")
        codeBuilder.append("  isNullable: Boolean = false,\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  ${type.getBuilderDefinition(resolver.loadClass(jsElementName))},\n")
        }
        codeBuilder.append("): ${declaration.jsName}${declaration.genericTypesString} ${declaration.whereClauseString}")
        codeBuilder.append(" = ")
        codeBuilder.append("$className(")
        codeBuilder.append("value, ")
        codeBuilder.append("isNullable, ")
        declaration.getGenericReturnTypes(resolver).joinToString { item -> "${item.declaration.name.replaceFirstChar { it.lowercase() }}Builder" }.let {
            codeBuilder.append(it)
        }
        codeBuilder.append(")\n")

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
        declaration.typeParameters.forEach { parameter ->
            parameter.bounds.map { type ->
                imports.add(type.resolve().declaration.fullName)
                type.resolve().getAllTypes()
            }.flatten().forEach {
                imports.add(it.declaration.fullName)
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
        logger.info("Generated interface file for class: $fileName.kt")
    }
}