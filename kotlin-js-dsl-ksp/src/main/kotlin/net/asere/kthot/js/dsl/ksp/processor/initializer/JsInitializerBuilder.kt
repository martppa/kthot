package net.asere.kthot.js.dsl.ksp.processor.initializer

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import net.asere.kthot.js.dsl.ksp.extension.*
import net.asere.kthot.js.dsl.ksp.processor.jsInitConfigName
import net.asere.kthot.js.dsl.ksp.processor.jsKthotCoreName
import net.asere.kthot.js.dsl.ksp.processor.jsKthotDomName
import net.asere.kthot.js.dsl.ksp.processor.jsRegisterFunctionName
import java.io.OutputStreamWriter

class JsInitializerBuilder(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) {

    private val imports = mutableListOf<String>()
    private val registers = mutableListOf<String>()
    private val writers = mutableListOf<String>()

    fun addType(clazz: KSClassDeclaration) {
        if (clazz.typeParameters.isEmpty()) {
            imports.add("import ${clazz.fullJsName}\n")
            imports.add("import ${clazz.packageName.asString()}.syntax\n")
            registers.add("        register(builder = ${clazz.jsName}::syntax)\n")
        }
    }

    fun addWriter(clazz: KSClassDeclaration) {
        imports.add("import ${clazz.fullJsName}Writer\n")
        writers.add("        ${clazz.jsName}Writer(config.jsOutputPath).write()\n")
    }

    fun build(
        resolver: Resolver,
    ) {
        val className = "Kthot"
        val packageName = "net.asere.kthot.js.dsl.ksp"
        val codeBuilder = StringBuilder()
        codeBuilder.append("package $packageName\n\n")

        val domJsTypeRegister = resolver.getClass(jsKthotDomName)
        val basicJsTypeRegister = resolver.loadClass(jsKthotCoreName)

        domJsTypeRegister?.let {
            imports.add("import ${it.fullName}\n")
        } ?: imports.add("import ${basicJsTypeRegister.fullName}\n")

        imports.forEach {
            codeBuilder.append(it)
        }

        codeBuilder.append("import $jsInitConfigName\n")
        codeBuilder.append("import $jsRegisterFunctionName\n")
        codeBuilder.append("\n\n")
        if (resolver.classExist(jsKthotDomName)) {
            codeBuilder.append("object $className : ${resolver.loadClass(jsKthotDomName).jsName}() {\n")
        } else {
            codeBuilder.append("object $className : ${resolver.loadClass(jsKthotCoreName).jsName}() {\n")
        }
        val config = resolver.loadClass(jsInitConfigName)
        codeBuilder.append("    private var config: ${config.name} = ${config.name}()\n")
        codeBuilder.append("\n")
        codeBuilder.append("    fun setConfig(config: ${config.name}): Kthot {\n")
        codeBuilder.append("        this.config = config\n")
        codeBuilder.append("        return this\n")
        codeBuilder.append("    }\n")
        codeBuilder.append("\n")
        codeBuilder.append("    override fun initialize() {\n")
        codeBuilder.append("        super.initialize()\n")
        registers.forEach(codeBuilder::append)
        writers.forEach(codeBuilder::append)
        codeBuilder.append("    }\n")
        codeBuilder.append("}\n")

        if (!resolver.fileExists("$className.kt")) {
            writeToFile(
                className = className,
                packageName = packageName,
                codeBuilder = codeBuilder,
            )
        }
    }

    private fun writeToFile(
        packageName: String,
        className: String,
        codeBuilder: StringBuilder
    ) {
        codeGenerator.createNewFile(
            dependencies = Dependencies(aggregating = false),
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