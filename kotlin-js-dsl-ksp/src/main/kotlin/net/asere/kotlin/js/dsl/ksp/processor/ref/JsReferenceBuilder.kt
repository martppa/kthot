package net.asere.kotlin.js.dsl.ksp.processor.ref

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import net.asere.kotlin.js.dsl.ksp.extension.*
import net.asere.kotlin.js.dsl.ksp.processor.CodeBuilder
import net.asere.kotlin.js.dsl.ksp.processor.jsElementName
import net.asere.kotlin.js.dsl.ksp.processor.jsInternalApiAnnotationName
import net.asere.kotlin.js.dsl.ksp.processor.jsPrintableDefinitionName
import net.asere.kotlin.js.dsl.ksp.processor.jsProvideFunctionName
import net.asere.kotlin.js.dsl.ksp.processor.jsReferenceIdName
import net.asere.kotlin.js.dsl.ksp.processor.jsValueRefName
import java.io.OutputStreamWriter

class JsReferenceBuilder(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : CodeBuilder {

    override fun build(resolver: Resolver, declaration: KSClassDeclaration) {
        createReference(declaration, resolver)
    }

    private fun createReference(declaration: KSClassDeclaration, resolver: Resolver) {
        val printableDefinition = resolver.loadClass(jsPrintableDefinitionName)
        val packageName = declaration.packageName.asString()
        val codeBuilder = StringBuilder()
        if (packageName.isNotBlank()) {
            codeBuilder.append("package $packageName\n\n")
        }
        codeBuilder.appendImports(declaration, resolver)
        val className = declaration.jsName + "Ref"
        codeBuilder.append("class $className${declaration.genericTypesDeclarationString()} @InternalApi constructor(\n")
        codeBuilder.append("  name: String? = null,\n")
        codeBuilder.append("  isNullable: Boolean = false,\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  override val ${type.getBuilderDefinition(resolver.loadClass(jsElementName))},\n")
        }
        codeBuilder.append(") : ${declaration.jsName}${declaration.genericTypesString}, ")
        codeBuilder.append("${resolver.loadClass(jsValueRefName)}<${declaration.jsName}${declaration.genericTypesString}>(\n")
        codeBuilder.append($$$"   name = name ?: \"$$${declaration.jsName.lowercase()}_${ReferenceId.nextRefInt()}\",\n")
        codeBuilder.append("   isNullable = isNullable\n")
        codeBuilder.append(") ${declaration.whereClauseString} {\n")
        codeBuilder.append("   override fun toString(): String = present()\n")
        codeBuilder.append("}\n\n")

        codeBuilder.append("@OptIn(InternalApi::class)\n")
        codeBuilder.append("inline fun ${declaration.genericTypesDeclarationString("reified")} ${declaration.jsName}.Companion.ref(\n")
        codeBuilder.append("  name: String? = null,\n")
        codeBuilder.append("  isNullable: Boolean = false,\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  noinline ${type.getBuilderDefinition(resolver.loadClass(jsElementName))} = ::provide,\n")
        }
        codeBuilder.append("): ${declaration.jsName}${declaration.genericTypesString} ${declaration.whereClauseString} = $className(name, isNullable, ")
        declaration.getGenericReturnTypes(resolver).joinToString { item -> "${item.declaration.name.replaceFirstChar { it.lowercase() }}Builder" }.let {
            codeBuilder.append(it)
        }
        codeBuilder.append(")\n\n")

        codeBuilder.append("@OptIn(InternalApi::class)\n")
        codeBuilder.append("inline fun ${declaration.genericTypesDeclarationString("reified")} ${declaration.jsName}.Companion.def(\n")
        codeBuilder.append("  name: String? = null,\n")
        codeBuilder.append("  isNullable: Boolean = false,\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  noinline ${type.getBuilderDefinition(resolver.loadClass(jsElementName))} = ::provide,\n")
        }
        codeBuilder.append("): ${printableDefinition.name}<${declaration.jsName}Ref${declaration.genericTypesString}, ${declaration.jsName}${declaration.genericTypesString}>\n")
        codeBuilder.append("${declaration.whereClauseString} = object : ${printableDefinition.name}<${declaration.jsName}Ref${declaration.genericTypesString}, ${declaration.jsName}${declaration.genericTypesString}>() {\n")
        codeBuilder.append("  override val reference: ${declaration.jsName}Ref${declaration.genericTypesString} = $className(name, isNullable, ")
        declaration.getGenericReturnTypes(resolver).joinToString { item -> "${item.declaration.name.replaceFirstChar { it.lowercase() }}Builder" }.let {
            codeBuilder.append(it)
        }
        codeBuilder.append(")\n}")

        writeToFile(
            fileName = className,
            packageName = packageName,
            declaration = declaration,
            codeBuilder = codeBuilder
        )
    }

    private fun StringBuilder.appendImports(declaration: KSClassDeclaration, resolver: Resolver) {
        val imports: MutableSet<String> = mutableSetOf()

        imports.add(resolver.loadClass(jsValueRefName).fullName)
        imports.add(resolver.loadClass(jsReferenceIdName).fullName)
        imports.add(resolver.loadClass(jsPrintableDefinitionName).fullName)
        imports.add(resolver.loadClass(jsInternalApiAnnotationName).fullName)
        imports.add(jsProvideFunctionName)

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