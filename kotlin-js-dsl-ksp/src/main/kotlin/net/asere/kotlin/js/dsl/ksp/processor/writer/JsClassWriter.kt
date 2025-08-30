package net.asere.kotlin.js.dsl.ksp.processor.writer

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.Path


abstract class JsClassWriter(
    private val path: String,
) {
    protected val codeBuilder: StringBuilder = StringBuilder()

    protected fun addProperty(name: String, isStatic: Boolean = false, isPrivate: Boolean = false) {
        codeBuilder.append("        ${if (isStatic) "static " else ""}${if (isPrivate) "#" else ""}$name")
    }

    protected fun addClassHeader(clasName: String, parents: List<String> = emptyList()) {
        codeBuilder.append(
            "export class $clasName${
                if (parents.isNotEmpty()) "extends ${parents.joinToString(", ")}" else ""
            } {\n"
        )
    }

    protected fun addFunction(
        name: String,
        parameters: List<String>,
        body: JsSyntax,
        isStatic: Boolean = false,
        isPrivate: Boolean = false
    ) {
        codeBuilder.append(
            "${if (isStatic) "static " else ""}${if (isPrivate) "#" else ""}$name(${
                parameters.joinToString(
                    ", "
                )
            }) { \n $body \n }\n"
        )
    }

    protected fun addConstructor(vararg ownProperties: String, body: JsSyntax) {
        codeBuilder.append("\n")
        codeBuilder.append("    constructor(${ownProperties.joinToString(", ")}) {\n")
        codeBuilder.append("$body\n")
        codeBuilder.append("    }\n")
    }

    protected fun finishClassDeclaration() {
        codeBuilder.append("\n}")
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