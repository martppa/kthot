package net.asere.kthot.js.dsl.ksp.processor.helper

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import net.asere.kthot.js.dsl.ksp.processor.helper.imports.ImportSyntaxBlock
import java.io.OutputStreamWriter

class FileWriter(
    private val fileName: String,
    private val packageName: String,
    private val codeGenerator: CodeGenerator,
) {
    private val imports = mutableSetOf<String>()
    private val codeBuilder = StringBuilder()

    fun import(block: ImportSyntaxBlock) {
        imports.add(block.value)
    }

    fun append(value: String) {
        codeBuilder.append(value)
    }

    fun write() {
        val builder = StringBuilder()
        builder.append("package $packageName\n\n")
        builder.append("${imports.joinToString("") { "import $it\n" }}\n")
        builder.append(codeBuilder.toString())
        val file = codeGenerator.createNewFile(
            dependencies = Dependencies(false),
            packageName = packageName,
            fileName = fileName,
            extensionName = "kt"
        )
        OutputStreamWriter(file).use { it.write(builder.toString()) }
    }
}