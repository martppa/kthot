package net.asere.kotlin.js.dsl.ksp.processor.ref

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.validate
import net.asere.kotlin.js.dsl.ksp.extension.*
import net.asere.kotlin.js.dsl.ksp.processor.*
import java.io.OutputStreamWriter

class JsReferenceProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {

        val declarations = findDeclarations(resolver) ?: return emptyList()

        for (declaration in declarations) {
            createReference(declaration, resolver)
        }

        return declarations.filterNot { it.validate() }.toList()
    }

    private fun createReference(declaration: KSClassDeclaration, resolver: Resolver) {
        val printableDefinition = resolver.loadClass(jsPrintableDefinitionName)
        val packageName = declaration.packageName.asString()
        val codeBuilder = StringBuilder()
        if (packageName.isNotBlank()) {
            codeBuilder.append("package $packageName\n\n")
        }
        codeBuilder.appendImports(declaration, resolver)
        val className = codeBuilder.appendDeclaration(declaration, resolver)
        codeBuilder.append(" {\n")
        codeBuilder.append("   override fun toString(): String = present()")
        codeBuilder.append("\n}")
        codeBuilder.append("\n")
        codeBuilder.append("\n")

        codeBuilder.append("fun ${declaration.genericTypesDeclarationString} ${declaration.jsName}.Companion.ref(\n")
        codeBuilder.append("  name: String? = null,\n")
        codeBuilder.append("  isNullable: Boolean = false,\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  ${type.getBuilderDefinition(resolver.loadClass(jsElementName))},\n")
        }
        codeBuilder.append("): ")
        codeBuilder.append(declaration.jsName)
        codeBuilder.append(declaration.genericTypesString)
        codeBuilder.append(declaration.whereClauseString)
        codeBuilder.append(" = ")
        codeBuilder.append("$className(")
        codeBuilder.append("name, ")
        codeBuilder.append("isNullable, ")
        declaration.getGenericReturnTypes(resolver).joinToString { item -> "${item.declaration.name.replaceFirstChar { it.lowercase() }}Builder" }.let {
            codeBuilder.append(it)
        }
        codeBuilder.append(")")
        codeBuilder.append("\n")
        codeBuilder.append("\n")

        codeBuilder.append("fun ${declaration.genericTypesDeclarationString} ${declaration.jsName}.Companion.def(\n")
        codeBuilder.append("  name: String? = null,\n")
        codeBuilder.append("  isNullable: Boolean = false,\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  ${type.getBuilderDefinition(resolver.loadClass(jsElementName))},\n")
        }
        codeBuilder.append("): ")
        codeBuilder.append(printableDefinition.name)
        codeBuilder.append("<${declaration.jsName}Ref${declaration.genericTypesString}, ${declaration.jsName}${declaration.genericTypesString}>")
        codeBuilder.append(declaration.whereClauseString)
        codeBuilder.append(" = object :")
        codeBuilder.append(" ${printableDefinition.name}")
        codeBuilder.append("<${declaration.jsName}Ref${declaration.genericTypesString}, ${declaration.jsName}${declaration.genericTypesString}>")
        codeBuilder.append("()")
        codeBuilder.append("{\n")
        codeBuilder.append("  override val reference: ${declaration.jsName}Ref${declaration.genericTypesString}")
        codeBuilder.append(" = ")
        codeBuilder.append("$className(")
        codeBuilder.append("name, ")
        codeBuilder.append("isNullable, ")
        declaration.getGenericReturnTypes(resolver).joinToString { item -> "${item.declaration.name.replaceFirstChar { it.lowercase() }}Builder" }.let {
            codeBuilder.append(it)
        }
        codeBuilder.append(")")
        codeBuilder.append("\n}")

        writeToFile(
            fileName = className,
            packageName = packageName,
            declaration = declaration,
            codeBuilder = codeBuilder
        )
    }

    private fun StringBuilder.appendDeclaration(declaration: KSClassDeclaration, resolver: Resolver): String {
        val className = declaration.jsName + "Ref"
        append("class ${declaration.getDeclaration(name = className, resolver = resolver)}")
        return className
    }

    private fun StringBuilder.appendImports(declaration: KSClassDeclaration, resolver: Resolver) {
        val imports: MutableSet<String> = mutableSetOf()

        imports.add(resolver.loadClass(jsValueRefName).fullName)
        imports.add(resolver.loadClass(jsReferenceIdName).fullName)
        imports.add(resolver.loadClass(jsPrintableDefinitionName).fullName)

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

    private fun findDeclarations(resolver: Resolver): Sequence<KSClassDeclaration>? {
        val symbols = resolver.getSymbolsWithAnnotation(jsClassAnnotationName)
            .filterIsInstance<KSClassDeclaration>()
        if (!symbols.iterator().hasNext()) {
            return null
        }
        return symbols
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

private fun KSClassDeclaration.getDeclaration(name: String, resolver: Resolver): String {
    val stringBuilder = StringBuilder()
    stringBuilder.append(name)
    stringBuilder.append(genericTypesDeclarationString)
    stringBuilder.append("(\n")
    stringBuilder.append("  name: String? = null,\n")
    stringBuilder.append("  isNullable: Boolean = false,\n")
    getGenericReturnTypes(resolver).forEach { type ->
        stringBuilder.append("  override val ${type.getBuilderDefinition(resolver.loadClass(jsElementName))},\n")
    }
    stringBuilder.append(") : $jsName")
    stringBuilder.append("$genericTypesString, ")
    stringBuilder.append("${resolver.loadClass(jsValueRefName)}<${jsName}${genericTypesString}>(\n")
    stringBuilder.append($$$"   name = name ?: \"$$${jsName.lowercase()}_${ReferenceId.nextRefInt()}\",\n")
    stringBuilder.append("   isNullable = isNullable")
    stringBuilder.append("\n)")
    stringBuilder.append(whereClauseString)

    return stringBuilder.toString()
}