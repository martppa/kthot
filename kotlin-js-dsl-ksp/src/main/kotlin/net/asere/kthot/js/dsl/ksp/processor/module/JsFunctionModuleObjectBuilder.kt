package net.asere.kthot.js.dsl.ksp.processor.module

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import net.asere.kthot.js.dsl.ksp.extension.findJsFunctions
import net.asere.kthot.js.dsl.ksp.extension.fullName
import net.asere.kthot.js.dsl.ksp.extension.isMarkedAsClass
import net.asere.kthot.js.dsl.ksp.extension.jsName
import net.asere.kthot.js.dsl.ksp.extension.loadClass
import net.asere.kthot.js.dsl.ksp.extension.name
import net.asere.kthot.js.dsl.ksp.processor.ClassCodeBuilder
import net.asere.kthot.js.dsl.ksp.processor.jsModuleItemName
import net.asere.kthot.js.dsl.ksp.processor.jsModuleName
import java.io.OutputStreamWriter

class JsFunctionModuleObjectBuilder(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : ClassCodeBuilder {

    override fun build(
        resolver: Resolver,
        declaration: KSClassDeclaration
    ) {
        val packageName = declaration.packageName.asString()
        val codeBuilder = StringBuilder()
        if (packageName.isNotBlank()) {
            codeBuilder.append("package $packageName\n\n")
        }
        val jsModuleDeclaration: KSClassDeclaration = resolver.loadClass(jsModuleName)
        val jsModuleItemDeclaration: KSClassDeclaration = resolver.loadClass(jsModuleItemName)

        codeBuilder.append("import ${jsModuleDeclaration.fullName}\n")
        codeBuilder.append("import ${jsModuleItemDeclaration.fullName}\n")
        codeBuilder.append("\n")

        val className = declaration.jsName + "Module"
        codeBuilder.append("class $className : ${jsModuleDeclaration.name} {\n")
        codeBuilder.append("  override val name: String = \"${declaration.jsName}\"\n")
        codeBuilder.append("  override val url: String = \"/${
            declaration.packageName.asString().replace(".", "/")
        }/${declaration.jsName}.js\"\n")
        val itemNames = if (declaration.isMarkedAsClass) {
            listOf(declaration.jsName)
        } else {
            declaration.findJsFunctions().map { it.jsName }
        }
        codeBuilder.append("  override val items: List<${jsModuleItemDeclaration.name}> = listOf(\n${
            itemNames.joinToString { "${jsModuleItemDeclaration.name}(\"${it}\")" }
        }\n)\n")
        itemNames.forEach {
            codeBuilder.append("  val ${it}: ${jsModuleItemDeclaration.name} = ${jsModuleItemDeclaration.name}(\"${it}\")\n")
        }
        codeBuilder.append("}")

        writeToFile(
            fileName = className,
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