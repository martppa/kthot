package net.asere.kotlin.js.dsl.ksp.processor.initializer

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import net.asere.kotlin.js.dsl.ksp.extension.findJsClasses
import net.asere.kotlin.js.dsl.ksp.extension.fullName
import net.asere.kotlin.js.dsl.ksp.extension.jsName
import net.asere.kotlin.js.dsl.ksp.extension.loadClass
import net.asere.kotlin.js.dsl.ksp.processor.jsDslLibName
import net.asere.kotlin.js.dsl.ksp.processor.jsRegisterFunctionName
import java.io.OutputStreamWriter

class JsInitializerBuilder(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) {

    fun build(
        resolver: Resolver,
    ) {
        val jsDslLibDefinition = resolver.loadClass(jsDslLibName)
        val className = "KotlinJsKsp"
        val packageName = "net.asere.kotlin.js.dsl.ksp"
        val codeBuilder = StringBuilder()
        codeBuilder.append("package $packageName\n\n")

        val classes = resolver.findJsClasses().filter { it.typeParameters.isEmpty() }

        val imports = mutableSetOf<String>()

        classes.forEach {
            imports.add("import ${it.packageName.asString()}.${it.jsName}\n")
            imports.add("import ${it.packageName.asString()}.syntax\n")
        }

        imports.forEach {
            codeBuilder.append(it)
        }

        codeBuilder.append("import ${jsDslLibDefinition.fullName}\n")
        codeBuilder.append("import $jsRegisterFunctionName\n")
        codeBuilder.append("\n\n")
        codeBuilder.append("object $className : ${jsDslLibDefinition.jsName} {\n")
        codeBuilder.append("    override fun initialize() {\n")
        classes.forEach {
            codeBuilder.append("        register(builder = ${it.jsName}::syntax)\n")
        }
        codeBuilder.append("    }\n")
        codeBuilder.append("}\n")

        writeToFile(
            resolver = resolver,
            className = className,
            packageName = packageName,
            codeBuilder = codeBuilder,
        )
    }

    private fun writeToFile(
        resolver: Resolver,
        packageName: String,
        className: String,
        codeBuilder: StringBuilder
    ) {
        val originatingFiles = resolver.getAllFiles().toList()

        codeGenerator.createNewFile(
            dependencies = Dependencies(aggregating = false, sources = originatingFiles.toTypedArray()),
            packageName = packageName,
            fileName = className,
            extensionName = "kt",
        ).use { outputStream ->
            OutputStreamWriter(outputStream).use { writer ->
                writer.write(codeBuilder.toString())
            }
        }

    }
}