package net.asere.kthot.js.dsl.ksp.processor.intf

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import net.asere.kthot.js.dsl.ksp.extension.fullJsName
import net.asere.kthot.js.dsl.ksp.extension.getDeclaration
import net.asere.kthot.js.dsl.ksp.extension.jsName
import net.asere.kthot.js.dsl.ksp.extension.name
import net.asere.kthot.js.dsl.ksp.processor.jsApiClassAnnotationName

class JsApiInterfaceBuilder(
    codeGenerator: CodeGenerator,
    logger: KSPLogger
) : JsInterfaceBuilder(
    codeGenerator, logger
) {
    override fun appendHeader(stringBuilder: StringBuilder, declaration: KSClassDeclaration): Unit = with(stringBuilder) {
        append("@OptIn(${jsInternalApiAnnotationDeclaration.name}::class)\n")
        append("interface ${declaration.getDeclaration(declaration.jsName)} {\n")
    }

    override fun appendCompanion(stringBuilder: StringBuilder, resolver: Resolver, declaration: KSClassDeclaration): Unit = with(stringBuilder) {
        append("\n")
        append("   companion object {\n")
        append("   }\n")
    }

    override fun getImportPath(declaration: KSClassDeclaration): String? {
        val jsClassAnnotation = declaration.annotations.find {
            it.annotationType.resolve().declaration.qualifiedName?.asString() == jsApiClassAnnotationName
        } ?: throw IllegalArgumentException("The declaration has no import path associated")
        val value =  jsClassAnnotation.arguments.find {
            it.name?.asString() == "import"
        }?.value as? String
        return if (value.isNullOrBlank()) {
            null
        } else value
    }
}