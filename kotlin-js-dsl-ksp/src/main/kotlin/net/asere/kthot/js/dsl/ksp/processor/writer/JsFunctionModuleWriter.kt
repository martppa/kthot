package net.asere.kthot.js.dsl.ksp.processor.writer

import net.asere.kthot.js.dsl.syntax.module.JsModule
import net.asere.kthot.js.dsl.syntax.module.asImportSyntax
import net.asere.kthot.js.dsl.type.JsElement
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.Path

abstract class JsFunctionModuleWriter(
    private val path: String,
) {
    protected val codeBuilder: StringBuilder = StringBuilder()

    protected fun addImport(module: JsModule) {
        codeBuilder.append(module.asImportSyntax())
    }

    protected fun addFunction(
        name: String,
        parameters: List<String>,
        body: JsElement,
        isStatic: Boolean = false,
        isPrivate: Boolean = false,
        isAsync: Boolean = false,
    ) {
        codeBuilder.append(
            "export ${if (isStatic) "static " else ""}${if (isPrivate) "#" else ""}${if (isAsync) "async " else ""} function $name(${
                parameters.joinToString(
                    ", "
                )
            }) { \n $body \n }\n"
        )
    }

    abstract fun write()

    protected fun writeToFile(
        fileName: String,
        packageName: String,
    ) {
        var directoryPath = Paths.get(System.getProperty("user.dir"), path)

        try {
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath)
            }
            for (directory in packageName.split(".")) {
                directoryPath = Path("$directoryPath/$directory")
                if (!Files.exists(directoryPath)) {
                    Files.createDirectories(directoryPath)
                }
            }

            Files.writeString(directoryPath.resolve(fileName), codeBuilder.toString(), StandardCharsets.UTF_8)
        } catch (e: IOException) {
            throw IOException("Error performing file operation: " + e.message)
        }
    }
}