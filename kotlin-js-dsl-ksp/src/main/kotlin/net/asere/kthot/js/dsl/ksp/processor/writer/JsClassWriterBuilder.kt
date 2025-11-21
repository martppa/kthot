package net.asere.kthot.js.dsl.ksp.processor.writer

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSDeclaration
import com.google.devtools.ksp.symbol.KSTypeParameter
import net.asere.kthot.js.dsl.ksp.extension.*
import net.asere.kthot.js.dsl.ksp.processor.*
import java.io.OutputStreamWriter

class JsClassWriterBuilder(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : ClassCodeBuilder {

    private val requirements = mutableSetOf<String>()
    private val imports = mutableSetOf<String>()

    override fun build(resolver: Resolver, declaration: KSClassDeclaration) {
        val writerName = "${declaration.jsName}Writer"
        val packageName = declaration.packageName.asString()
        val codeBuilder = StringBuilder()
        if (packageName.isNotBlank()) {
            codeBuilder.append("package $packageName\n\n")
        }

        val classWriter = resolver.loadClass(jsClassWriterName)
        val jsDslAnnotation = resolver.loadClass(jsDslAnnotationName)
        val jsObjectClass = resolver.loadClass(jsObjectName)
        val jsGenericsClass = resolver.loadClass(jsGenericsName)

        imports.add("import ${jsDslAnnotation.fullName}\n")
        imports.add("import ${classWriter.fullName}\n")
        imports.add("import ${resolver.loadClass(jsValueName).fullName}\n")
        imports.add("import ${jsGenericsClass.fullName}\n")
        imports.add("import ${jsObjectClass.fullName}\n")
        imports.add("import ${jsObjectClass.packageName.asString()}.syntax\n")

        declaration.getAllTypes().filter { it.isJsElement(resolver) }.forEach {
            imports.add("import ${it.declaration.fullName}\n")
            if (it.declaration.isImportable)
                requirements.add("${it.declaration.jsName}.Module")
        }

        declaration.getGenericReturnTypes(resolver).filter { !it.isGenericType }.forEach {
            imports.add("import ${it.declaration.fullName}\n")
        }

        declaration.findJsConstructors().firstOrNull()?.parameters?.forEach {
            if (!it.type.isGenericTypeParameter() && it.type.resolve().declaration.isJsElement(resolver)) {
                imports.add("import ${it.type.resolve().declaration.fullName}\n")
                imports.add("import ${it.type.resolve().declaration.fullBasicTypeName}\n")
                imports.add("import ${it.type.resolve().declaration.packageName.asString()}.ref\n")
                if (it.type.resolve().declaration.isImportable)
                    requirements.add("${it.type.resolve().declaration.jsName}.Module")
            }
        }
        declaration.findJsFunctions().map { it.parameters }.flatten().forEach {
            if (!it.type.isGenericTypeParameter()) {
                imports.add("import ${it.type.resolve().declaration.fullName}\n")
                imports.add("import ${it.type.resolve().declaration.fullBasicTypeName}\n")
                imports.add("import ${it.type.resolve().declaration.packageName.asString()}.ref\n")
                if (it is KSDeclaration && it.isImportable)
                    requirements.add("${it.jsName}.Module")
            }
        }
        imports.add("import $jsProvideFunctionName\n")
        imports.add("import $jsSyntaxName\n")

        imports.forEach { codeBuilder.append(it) }
        codeBuilder.append("\n")

        codeBuilder.append("class $writerName(path: String) : ${classWriter.name}(path) {\n")
        codeBuilder.append("\n")
        codeBuilder.append("   override fun write() {\n")
        requirements.forEach {
            codeBuilder.append("    addRequire($it)\n")
        }
        codeBuilder.append("        val instance = ${declaration.name}${declaration.asType(listOf()).definitionTypesAsJsGenerics}(\n${
            declaration.findJsConstructors().firstOrNull()?.parameters?.mapIndexed { index, item -> 
                (item.name?.asString() ?: "p$index").let { name -> 
                    if (item.type.isGenericTypeParameter()) {
                        "           $name = provide(JsSyntax(\"$name\"))\n"
                    } else if (item.type.isBuilderFunction) {
                        "           $name = ::provide\n"
                    } else {
                        "           $name = ${item.type.resolve().declaration.basicJsName}.ref(\"$name\")\n"
                    }
                }
            }?.joinToString { it } ?: ""
        })\n")
        codeBuilder.append("        instance.requirements.forEach { it -> addImport(it) }\n")
        codeBuilder.append("        addClassHeader(\"${declaration.jsName}\")\n")
        declaration.findJsConstructors().forEach {
            codeBuilder.append("        addConstructor(${it.parameters.joinToString { param -> 
                val parameterType = param.type.resolve()
                if (!parameterType.isJsElement(resolver) && !parameterType.isGenericType && !parameterType.isBuilderFunction)
                    throw IllegalArgumentException("Constructor properties of type '${declaration.jsName}' must be JsElement types or type builders '(JsElement) -> T'.")
                "\"${param.name?.asString() ?: "" }\""
            }}, body = instance.constructorBody ?: JsSyntax(\"\"))\n")
        }
        declaration.findJsFunctions().forEach { function ->
            codeBuilder.append("        addFunction(isAsync = ${function.isAsync}, name = \"${function.name}\", parameters = listOf(${function.parameters.joinToString { param ->
                "\"${param.name?.asString() ?: "" }\""
            }}), body = instance.${function.name}(${function.parameters.mapIndexed { index, item ->
                (item.name?.asString() ?: "p$index").let { name ->
                    if (item.type.isGenericTypeParameter()) {
                        "           $name = ${jsGenericsClass.name}.syntax(\"$name\")\n"
                    } else {
                        "           $name = ${item.type.resolve().declaration.basicJsName}.ref${item.type.resolve().definitionTypesAsJsGenerics}(\"$name\")\n"
                    }
                }
            }.joinToString { it } }))\n")
        }
        codeBuilder.append("        finishClassDeclaration()\n")
        codeBuilder.append("        writeToFile(\"${declaration.jsName}.js\", \"${declaration.packageName.asString()}\")\n")
        codeBuilder.append("   }")
        codeBuilder.append("\n")
        codeBuilder.append("}")

        codeBuilder.append("\n")
        codeBuilder.append("@${jsDslAnnotation.name}\n")
        if (declaration.typeParameters.isNotEmpty()) {
            codeBuilder.append("internal val ${declaration.genericTypesDeclarationString()} ${declaration.name}${declaration.genericTypesNamesString}.This get() = ${declaration.jsName}.syntax(\"this\", ${
                declaration.getGenericReturnTypes(resolver).joinToString { item -> "::provide" }
            })")
        } else {
            codeBuilder.append("internal val ${declaration.name}.This get() = ${declaration.jsName}.syntax(\"this\")")
        }

        writeToFile(
            fileName = writerName,
            packageName = packageName,
            declaration = declaration,
            codeBuilder = codeBuilder
        )
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