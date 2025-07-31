package net.asere.kotlin.js.dsl.ksp.processor

import com.google.devtools.ksp.getVisibility
import com.google.devtools.ksp.isConstructor
import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.Visibility
import com.google.devtools.ksp.validate
import net.asere.kotlin.js.dsl.ksp.extension.fullName
import net.asere.kotlin.js.dsl.ksp.extension.name
import net.asere.kotlin.js.dsl.ksp.extension.typeFullName
import net.asere.kotlin.js.dsl.ksp.extension.typeName
import net.asere.kotlin.js.dsl.ksp.extension.typePackage
import java.io.OutputStreamWriter

class JsInterfaceProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {

    private val jsClassAnnotationName = "net.asere.kotlin.js.dsl.ksp.annotation.JsClass"


    override fun process(resolver: Resolver): List<KSAnnotated> {

        val declarations = findDeclarations(resolver) ?: return emptyList()

        for (declaration in declarations) {
            createInterface(declaration)
        }

        return declarations.filterNot { it.validate() }.toList()
    }

    private fun createInterface(declaration: KSClassDeclaration) {
        val jsClassAnnotation = declaration.annotations.find {
            it.annotationType.resolve().declaration.qualifiedName?.asString() == jsClassAnnotationName
        } ?: throw IllegalStateException("@JsClass annotation not found on ${declaration.qualifiedName?.asString()}")

        val interfaceNameFromAnnotation = jsClassAnnotation.arguments.find { it.name?.asString() == "name" }?.value as? String
        val finalInterfaceName = if (interfaceNameFromAnnotation.isNullOrBlank()) {
            "Js${declaration.simpleName.asString()}"
        } else {
            interfaceNameFromAnnotation
        }

        val packageName = declaration.packageName.asString()
        val codeBuilder = StringBuilder()
        if (packageName.isNotBlank()) {
            codeBuilder.append("package $packageName\n\n")
        }
        appendImports(declaration, codeBuilder)
        codeBuilder.append("interface $finalInterfaceName {\n")
        appendProperties(declaration, codeBuilder)
        appendMethods(declaration, codeBuilder)
        writeToFile(
            fileName = finalInterfaceName,
            packageName = packageName,
            declaration = declaration,
            codeBuilder = codeBuilder
        )
    }

    private fun appendImports(declaration: KSClassDeclaration, codeBuilder: StringBuilder) {
        codeBuilder.append("import ${declaration.fullName}\n")
        declaration.getAllProperties().filter { it.getVisibility() == Visibility.PUBLIC }.forEach { property ->
            codeBuilder.append("import ${property.typeFullName}\n")
            codeBuilder.append("import ${property.typePackage}.ref\n")
        }
        codeBuilder.append("\n")
    }

    private fun appendProperties(declaration: KSClassDeclaration, codeBuilder: StringBuilder) {
        declaration.getAllProperties().filter { it.getVisibility() == Visibility.PUBLIC }.forEach { property ->
            val propertyName = property.name
            val propertyType = property.typeName
            codeBuilder.append("  val $propertyName: $propertyType get() = $propertyType.ref()\n")
        }
    }

    private fun appendMethods(declaration: KSClassDeclaration, codeBuilder: StringBuilder) {
        declaration.getAllFunctions()
            .filter { it.getVisibility() == Visibility.PUBLIC }
            .filter { !it.isConstructor() }
            .filter { !it.isFromKotlinAny() }
            .forEach { function ->
                val functionName = function.simpleName.asString()
                val returnType = function.returnType?.resolve()?.declaration?.qualifiedName?.asString() ?: "Unit"

                val params = function.parameters.joinToString(", ") { param ->
                    val paramName = param.name?.asString()
                    val paramType = param.type.resolve().declaration.qualifiedName?.asString() ?: "Any"
                    "$paramName: $paramType"
                }
                codeBuilder.append("  fun $functionName($params): $returnType\n")
            }

        codeBuilder.append("}\n")
    }

    private fun findDeclarations(resolver: Resolver): Sequence<KSClassDeclaration>? {
        val symbols = resolver.getSymbolsWithAnnotation(jsClassAnnotationName)
            .filterIsInstance<KSClassDeclaration>()
        if (!symbols.iterator().hasNext()) {
            return null
        }
        return symbols
    }

    private fun writeToFile(fileName: String, packageName: String, declaration: KSClassDeclaration, codeBuilder: StringBuilder) {
        val file = codeGenerator.createNewFile(
            dependencies = Dependencies(false, declaration.containingFile!!),
            packageName = packageName,
            fileName = fileName,
            extensionName = "kt"
        )
        OutputStreamWriter(file).use { it.write(codeBuilder.toString()) }
        logger.info("Generated interface file for class: $fileName.kt")
    }

    private fun KSFunctionDeclaration.isFromKotlinAny(): Boolean {
        val anyFunctions = setOf("equals", "hashCode", "toString")
        return simpleName.asString() in anyFunctions &&
                parentDeclaration?.qualifiedName?.asString() == "kotlin.Any"
    }
}