package net.asere.kthot.js.dsl.ksp.processor.intf

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import net.asere.kthot.js.dsl.ksp.processor.jsApiAnnotationName

class JsApiInterfaceBuilder(
    codeGenerator: CodeGenerator,
    logger: KSPLogger
) : JsInterfaceBuilder(
    codeGenerator, logger
) {
    override fun getImportPath(declaration: KSClassDeclaration): String? {
        val jsClassAnnotation = declaration.annotations.find {
            it.annotationType.resolve().declaration.qualifiedName?.asString() == jsApiAnnotationName
        } ?: throw IllegalArgumentException("The declaration has no import path associated")
        val value =  jsClassAnnotation.arguments.find {
            it.name?.asString() == "import"
        }?.value as? String
        return if (value.isNullOrBlank()) {
            null
        } else value
    }
}