package net.asere.kotlin.js.dsl.ksp.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.validate
import net.asere.kotlin.js.dsl.ksp.extension.findJsClasses
import net.asere.kotlin.js.dsl.ksp.extension.fullName
import net.asere.kotlin.js.dsl.ksp.processor.composite.CodeBuilderComposite
import net.asere.kotlin.js.dsl.ksp.processor.intf.JsInterfaceBuilder
import net.asere.kotlin.js.dsl.ksp.processor.ref.JsReferenceBuilder
import net.asere.kotlin.js.dsl.ksp.processor.syntax.JsSyntaxBuilder

class JsClassProcessor(
    codeGenerator: CodeGenerator,
    logger: KSPLogger
) : SymbolProcessor {

    private val mainBuilder = CodeBuilderComposite(
        JsInterfaceBuilder(codeGenerator, logger),
        JsReferenceBuilder(codeGenerator, logger),
        JsSyntaxBuilder(codeGenerator, logger),
    )

    override fun process(resolver: Resolver): List<KSAnnotated> {

        val declarations = resolver.findJsClasses()

        println(declarations.toList().map { it.fullName })

        for (declaration in declarations) {
            mainBuilder.build(resolver, declaration)
        }

        return emptyList()
    }
}