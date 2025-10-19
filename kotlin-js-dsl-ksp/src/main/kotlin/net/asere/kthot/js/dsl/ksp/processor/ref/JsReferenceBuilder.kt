package net.asere.kthot.js.dsl.ksp.processor.ref

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSTypeParameter
import net.asere.kthot.js.dsl.ksp.extension.*
import net.asere.kthot.js.dsl.ksp.processor.ClassCodeBuilder
import net.asere.kthot.js.dsl.ksp.processor.jsElementName
import net.asere.kthot.js.dsl.ksp.processor.jsInternalApiAnnotationName
import net.asere.kthot.js.dsl.ksp.processor.jsPrintableDefinitionName
import net.asere.kthot.js.dsl.ksp.processor.jsProvideFunctionName
import net.asere.kthot.js.dsl.ksp.processor.jsReferenceIdName
import net.asere.kthot.js.dsl.ksp.processor.jsValueRefName
import java.io.OutputStreamWriter

class JsReferenceBuilder(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : ClassCodeBuilder {

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
        codeBuilder.append("class $className${declaration.genericTypesDeclarationString()} @JsInternalApi constructor(\n")
        codeBuilder.append("  name: String? = null,\n")
        codeBuilder.append("  isNullable: Boolean = false${declaration.getComma(resolver)}\n")
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

        codeBuilder.append("@OptIn(JsInternalApi::class)\n")
        codeBuilder.append("${if (declaration.typeParameters.isNotEmpty()) "inline " else ""}fun ${declaration.genericTypesDeclarationString("reified")} ${declaration.jsName}.Companion.ref(\n")
        codeBuilder.append("  name: String? = null,\n")
        codeBuilder.append("  isNullable: Boolean = false,\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  noinline ${type.getBuilderDefinition(resolver.loadClass(jsElementName))} = ::provide,\n")
        }
        codeBuilder.append("): ${declaration.jsName}${declaration.genericTypesString} ${declaration.whereClauseString} = $className(name, isNullable${declaration.getComma(resolver)}")
        declaration.getGenericReturnTypes(resolver).joinToString { item -> item.builderName }.let {
            codeBuilder.append(it)
        }
        codeBuilder.append(")\n\n")

        codeBuilder.append("@OptIn(JsInternalApi::class)\n")
        codeBuilder.append("${if (declaration.typeParameters.isNotEmpty()) "inline " else ""}fun ${declaration.genericTypesDeclarationString("reified")} ${declaration.jsName}.Companion.ref(\n")
        codeBuilder.append("  element: JsElement,\n")
        codeBuilder.append("  isNullable: Boolean = false,\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  noinline ${type.getBuilderDefinition(resolver.loadClass(jsElementName))} = ::provide,\n")
        }
        codeBuilder.append($$$"): $$${declaration.jsName}$$${declaration.genericTypesString} $$${declaration.whereClauseString} = $$$className(element.present(), isNullable$$${declaration.getComma(resolver)}")
        declaration.getGenericReturnTypes(resolver).joinToString { item -> item.builderName }.let {
            codeBuilder.append(it)
        }
        codeBuilder.append(")\n\n")

        codeBuilder.append("@OptIn(JsInternalApi::class)\n")
        codeBuilder.append("${if (declaration.typeParameters.isNotEmpty()) "inline " else ""}fun ${declaration.genericTypesDeclarationString("reified")} ${declaration.jsName}.Companion.def(\n")
        codeBuilder.append("  name: String? = null,\n")
        codeBuilder.append("  isNullable: Boolean = false,\n")
        declaration.getGenericReturnTypes(resolver).forEach { type ->
            codeBuilder.append("  noinline ${type.getBuilderDefinition(resolver.loadClass(jsElementName))} = ::provide,\n")
        }
        codeBuilder.append("): ${printableDefinition.name}<${declaration.jsName}Ref${declaration.genericTypesString}, ${declaration.jsName}${declaration.genericTypesString}>\n")
        codeBuilder.append("${declaration.whereClauseString} = object : ${printableDefinition.name}<${declaration.jsName}Ref${declaration.genericTypesString}, ${declaration.jsName}${declaration.genericTypesString}>() {\n")
        codeBuilder.append("  override val reference: ${declaration.jsName}Ref${declaration.genericTypesString} = $className(name, isNullable${declaration.getComma(resolver)}")
        declaration.getGenericReturnTypes(resolver).joinToString { item -> item.builderName }.let {
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

        imports.add(resolver.loadClass(jsElementName).fullName)
        imports.add(resolver.loadClass(jsValueRefName).fullName)
        imports.add(resolver.loadClass(jsReferenceIdName).fullName)
        imports.add(resolver.loadClass(jsPrintableDefinitionName).fullName)
        imports.add(resolver.loadClass(jsInternalApiAnnotationName).fullName)
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