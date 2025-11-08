package net.asere.kthot.js.dsl.ksp.processor.intf

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import net.asere.kthot.js.dsl.ksp.extension.getDeclaration
import net.asere.kthot.js.dsl.ksp.extension.jsName
import net.asere.kthot.js.dsl.ksp.extension.loadClass
import net.asere.kthot.js.dsl.ksp.extension.name
import net.asere.kthot.js.dsl.ksp.processor.jsApiAnnotationName
import net.asere.kthot.js.dsl.ksp.processor.jsFunctionsModuleName

class JsApiInterfaceBuilder(
    codeGenerator: CodeGenerator,
    logger: KSPLogger
) : JsInterfaceBuilder(
    codeGenerator, logger
) {
    override fun StringBuilder.appendHeader(declaration: KSClassDeclaration) {
        append("@OptIn(${jsInternalApiAnnotationDeclaration.name}::class)\n")
        append("interface ${declaration.getDeclaration(declaration.jsName)} {\n")
    }

    override fun getModuleClass(resolver: Resolver): KSClassDeclaration {
        return resolver.loadClass(jsFunctionsModuleName)
    }

    override fun StringBuilder.appendCompanion(resolver: Resolver, declaration: KSClassDeclaration) {
        val moduleClass = resolver.loadClass(jsFunctionsModuleName)
        append("\n")
        append("   companion object {\n")
        append("       val Module = ${moduleClass.name}(\"${declaration.jsName}\", \"/${
            declaration.packageName.asString().replace(".", "/")
        }/${declaration.jsName}.js\")\n")
        append("   }\n")
    }

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