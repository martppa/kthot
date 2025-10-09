package net.asere.kthot.js.dsl.ksp.processor.api

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import net.asere.kthot.js.dsl.ksp.extension.findJsApiClasses
import net.asere.kthot.js.dsl.ksp.extension.findJsClasses
import net.asere.kthot.js.dsl.ksp.processor.composite.CodeBuilderComposite
import net.asere.kthot.js.dsl.ksp.processor.initializer.JsInitializerBuilder
import net.asere.kthot.js.dsl.ksp.processor.intf.JsApiInterfaceBuilder
import net.asere.kthot.js.dsl.ksp.processor.intf.JsInterfaceBuilder
import net.asere.kthot.js.dsl.ksp.processor.ref.JsReferenceBuilder
import net.asere.kthot.js.dsl.ksp.processor.syntax.JsSyntaxBuilder
import net.asere.kthot.js.dsl.ksp.processor.writer.JsClassWriterBuilder

class JsApiProcessor(
    codeGenerator: CodeGenerator,
    logger: KSPLogger
) : SymbolProcessor {

    private val mainBuilder = CodeBuilderComposite(
        JsApiInterfaceBuilder(codeGenerator, logger),
        JsReferenceBuilder(codeGenerator, logger),
        JsSyntaxBuilder(codeGenerator, logger),
    )
    private val initializerBuilder: JsInitializerBuilder = JsInitializerBuilder(
        codeGenerator = codeGenerator,
        logger = logger
    )

    override fun process(resolver: Resolver): List<KSAnnotated> {

        val declarations = resolver.findJsApiClasses()

        for (declaration in declarations) {
            mainBuilder.build(resolver, declaration)
        }
        if (declarations.toList().isNotEmpty()) {
            initializerBuilder.build(resolver)
        }

        return emptyList()
    }
}