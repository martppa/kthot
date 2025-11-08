package net.asere.kthot.js.dsl.ksp.processor.writer

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSDeclaration
import net.asere.kthot.js.dsl.ksp.extension.*
import net.asere.kthot.js.dsl.ksp.processor.*
import java.io.OutputStreamWriter

class JsFunctionModuleWriterBuilder(
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

        val classWriter = resolver.loadClass(jsFunctionModuleWriterName)
        val jsDslAnnotation = resolver.loadClass(jsDslAnnotationName)
        val jsObjectClass = resolver.loadClass(jsObjectName)

        imports.add("import ${jsDslAnnotation.fullName}\n")
        imports.add("import ${classWriter.fullName}\n")
        imports.add("import ${resolver.loadClass(jsValueName).fullName}\n")
        imports.add("import ${jsObjectClass.fullName}\n")
        imports.add("import ${jsObjectClass.packageName.asString()}.syntax\n")
        declaration.getAllTypes().forEach {
            imports.add("import ${it.declaration.fullName}\n")
            if (it.declaration.isImportable)
                requirements.add("${it.declaration.jsName}.Module")
        }

        declaration.findJsConstructors().firstOrNull()?.parameters?.forEach {
            if (!it.type.isGenericTypeParameter()) {
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
            codeBuilder.append("    addImport($it)\n")
        }
        codeBuilder.append("        val instance = ${declaration.name}()\n")
        codeBuilder.append("        instance.requirements.forEach { it -> addImport(it) }\n")
        declaration.findJsFunctions().forEach { function ->
            codeBuilder.append("        addFunction(isAsync = ${function.isAsync}, name = \"${function.name}\", parameters = listOf(${function.parameters.joinToString { param ->
                "\"${param.name?.asString() ?: "" }\""
            }}), body = instance.${function.name}(${function.parameters.mapIndexed { index, item ->
                (item.name?.asString() ?: "p$index").let { name ->
                    if (item.type.isGenericTypeParameter()) {
                        "           $name = JsObject.syntax(\"$name\", false)\n"
                    } else {
                        "           $name = ${item.type.resolve().declaration.basicJsName}.ref${item.type.resolve().declaration.genericTypesNamesString}(\"$name\")\n"
                    }
                }
            }.joinToString { it } }))\n")
        }
        codeBuilder.append("        writeToFile(\"${declaration.jsName}.js\", \"${declaration.packageName.asString()}\")\n")
        codeBuilder.append("   }")
        codeBuilder.append("\n")
        codeBuilder.append("}")

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