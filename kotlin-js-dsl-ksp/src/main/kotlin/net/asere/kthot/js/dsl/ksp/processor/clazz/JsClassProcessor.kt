package net.asere.kthot.js.dsl.ksp.processor.clazz

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import net.asere.kthot.js.dsl.ksp.extension.findJsApiClasses
import net.asere.kthot.js.dsl.ksp.extension.findJsApiFunctionsClasses
import net.asere.kthot.js.dsl.ksp.extension.findJsClasses
import net.asere.kthot.js.dsl.ksp.processor.composite.CodeBuilderComposite
import net.asere.kthot.js.dsl.ksp.processor.function.JsFunctionInterfaceBuilder
import net.asere.kthot.js.dsl.ksp.processor.initializer.JsInitializerBuilder
import net.asere.kthot.js.dsl.ksp.processor.intf.JsApiInterfaceBuilder
import net.asere.kthot.js.dsl.ksp.processor.intf.JsClassInterfaceBuilder
import net.asere.kthot.js.dsl.ksp.processor.ref.JsReferenceBuilder
import net.asere.kthot.js.dsl.ksp.processor.syntax.JsSyntaxBuilder
import net.asere.kthot.js.dsl.ksp.processor.writer.JsClassWriterBuilder

class JsClassProcessor(
    codeGenerator: CodeGenerator,
    logger: KSPLogger
) : SymbolProcessor {

    private val jsClassBuilder = CodeBuilderComposite(
        JsClassInterfaceBuilder(codeGenerator, logger),
        JsReferenceBuilder(codeGenerator, logger),
        JsSyntaxBuilder(codeGenerator, logger),
        JsClassWriterBuilder(codeGenerator, logger),
    )
    private val jsApiClassBuilder = CodeBuilderComposite(
        JsApiInterfaceBuilder(codeGenerator, logger),
        JsReferenceBuilder(codeGenerator, logger),
        JsSyntaxBuilder(codeGenerator, logger),
    )
    private val jsApiFunctionBuilder = CodeBuilderComposite(
        JsFunctionInterfaceBuilder(codeGenerator, logger),
    )
    private val initializerBuilder: JsInitializerBuilder = JsInitializerBuilder(
        codeGenerator = codeGenerator,
        logger = logger
    )

    override fun process(resolver: Resolver): List<KSAnnotated> {

        val classDeclarations = resolver.findJsClasses()

        for (declaration in classDeclarations) {
            jsClassBuilder.build(resolver, declaration)
        }

        val apiDeclarations = resolver.findJsApiClasses()

        for (declaration in apiDeclarations) {
            jsApiClassBuilder.build(resolver, declaration)
        }

        val apiFunctionClassDeclarations = resolver.findJsApiFunctionsClasses()

        for (declaration in apiFunctionClassDeclarations) {
            jsApiFunctionBuilder.build(resolver, declaration)
        }

        if ((apiDeclarations + classDeclarations + apiFunctionClassDeclarations).toList().isNotEmpty()) {
            initializerBuilder.build(resolver)
        }

        return emptyList()
    }
}