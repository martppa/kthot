package net.asere.kotlin.js.dsl.ksp.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import net.asere.kotlin.js.dsl.ksp.extension.findJsClasses
import net.asere.kotlin.js.dsl.ksp.processor.composite.CodeBuilderComposite
import net.asere.kotlin.js.dsl.ksp.processor.initializer.JsInitializerBuilder
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
    private val initializerBuilder: JsInitializerBuilder = JsInitializerBuilder(
        codeGenerator = codeGenerator,
        logger = logger
    )

    override fun process(resolver: Resolver): List<KSAnnotated> {

        val declarations = resolver.findJsClasses()

        for (declaration in declarations) {
            mainBuilder.build(resolver, declaration)
        }
        if (declarations.toList().isNotEmpty()) {
            initializerBuilder.build(resolver)
        }

        return emptyList()
    }
}