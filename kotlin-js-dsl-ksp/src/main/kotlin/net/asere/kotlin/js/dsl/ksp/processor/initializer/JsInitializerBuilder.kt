package net.asere.kotlin.js.dsl.ksp.processor.initializer

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import net.asere.kotlin.js.dsl.ksp.extension.classExist
import net.asere.kotlin.js.dsl.ksp.extension.findJsClasses
import net.asere.kotlin.js.dsl.ksp.extension.fullJsName
import net.asere.kotlin.js.dsl.ksp.extension.fullName
import net.asere.kotlin.js.dsl.ksp.extension.getClass
import net.asere.kotlin.js.dsl.ksp.extension.jsName
import net.asere.kotlin.js.dsl.ksp.extension.loadClass
import net.asere.kotlin.js.dsl.ksp.extension.name
import net.asere.kotlin.js.dsl.ksp.processor.jsBasicJsTypeRegisterName
import net.asere.kotlin.js.dsl.ksp.processor.jsDomJsTypeRegisterName
import net.asere.kotlin.js.dsl.ksp.processor.jsInitConfigName
import net.asere.kotlin.js.dsl.ksp.processor.jsRegisterFunctionName
import java.io.OutputStreamWriter

class JsInitializerBuilder(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) {

    fun build(
        resolver: Resolver,
    ) {
        val className = "KotlinJs"
        val packageName = "net.asere.kotlin.js.dsl.ksp"
        val codeBuilder = StringBuilder()
        codeBuilder.append("package $packageName\n\n")

        val classes = resolver.findJsClasses().filter { it.typeParameters.isEmpty() }

        val imports = mutableSetOf<String>()

        classes.forEach {
            imports.add("import ${it.packageName.asString()}.${it.jsName}\n")
            imports.add("import ${it.packageName.asString()}.syntax\n")
        }

        val domJsTypeRegister = resolver.getClass(jsDomJsTypeRegisterName)
        val basicJsTypeRegister = resolver.loadClass(jsBasicJsTypeRegisterName)

        domJsTypeRegister?.let {
            imports.add("import ${it.fullName}\n")
        } ?: imports.add("import ${basicJsTypeRegister.fullName}\n")

        resolver.findJsClasses().forEach {
            imports.add("import ${it.fullJsName}Writer\n")
        }

        imports.forEach {
            codeBuilder.append(it)
        }

        codeBuilder.append("import $jsInitConfigName\n")
        codeBuilder.append("import $jsRegisterFunctionName\n")
        codeBuilder.append("\n\n")
        if (resolver.classExist(jsDomJsTypeRegisterName)) {
            codeBuilder.append("object $className : ${resolver.loadClass(jsDomJsTypeRegisterName).jsName}() {\n")
        } else {
            codeBuilder.append("object $className : ${resolver.loadClass(jsBasicJsTypeRegisterName).jsName}() {\n")
        }
        val config = resolver.loadClass(jsInitConfigName)
        codeBuilder.append("    private var config: ${config.name} = ${config.name}()\n")
        codeBuilder.append("\n")
        codeBuilder.append("    fun setConfig(config: ${config.name}): KotlinJs {\n")
        codeBuilder.append("        this.config = config\n")
        codeBuilder.append("        return this\n")
        codeBuilder.append("    }\n")
        codeBuilder.append("\n")
        codeBuilder.append("    override fun initialize() {\n")
        codeBuilder.append("        super.initialize()\n")
        classes.forEach {
            codeBuilder.append("        register(builder = ${it.jsName}::syntax)\n")
        }
        resolver.findJsClasses().forEach {
            codeBuilder.append("        ${it.jsName}Writer(config.jsOutputPath).write()\n")
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