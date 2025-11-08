package net.asere.kthot.js.dsl.ksp.processor.clazz

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSDeclaration
import com.google.devtools.ksp.validate
import net.asere.kthot.js.dsl.ksp.extension.findJsApiClasses
import net.asere.kthot.js.dsl.ksp.extension.findJsApiFunctionsClasses
import net.asere.kthot.js.dsl.ksp.extension.findJsClasses
import net.asere.kthot.js.dsl.ksp.extension.findJsFunctionsFiles
import net.asere.kthot.js.dsl.ksp.extension.jsName
import net.asere.kthot.js.dsl.ksp.processor.composite.CodeBuilderComposite
import net.asere.kthot.js.dsl.ksp.processor.function.JsFunctionModuleBuilder
import net.asere.kthot.js.dsl.ksp.processor.initializer.JsInitializerBuilder
import net.asere.kthot.js.dsl.ksp.processor.intf.JsApiInterfaceBuilder
import net.asere.kthot.js.dsl.ksp.processor.intf.JsClassInterfaceBuilder
import net.asere.kthot.js.dsl.ksp.processor.ref.JsReferenceBuilder
import net.asere.kthot.js.dsl.ksp.processor.syntax.JsSyntaxBuilder
import net.asere.kthot.js.dsl.ksp.processor.writer.JsClassWriterBuilder
import net.asere.kthot.js.dsl.ksp.processor.writer.JsFunctionModuleWriterBuilder

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

    private val jsFunctionBuilder = CodeBuilderComposite(
        JsFunctionModuleBuilder(codeGenerator, logger),
        JsFunctionModuleWriterBuilder(codeGenerator, logger),
    )

    private val jsApiClassBuilder = CodeBuilderComposite(
        JsApiInterfaceBuilder(codeGenerator, logger),
        JsReferenceBuilder(codeGenerator, logger),
        JsSyntaxBuilder(codeGenerator, logger),
    )
    private val jsApiFunctionBuilder = CodeBuilderComposite(
        JsFunctionModuleBuilder(codeGenerator, logger),
    )
    private val initializerBuilder: JsInitializerBuilder = JsInitializerBuilder(
        codeGenerator = codeGenerator,
        logger = logger
    )

    override fun process(resolver: Resolver): List<KSAnnotated> {

        val nonProcessedSymbols: MutableList<KSDeclaration> = mutableListOf()

        val classDeclarations = resolver.findJsClasses()

        for (declaration in classDeclarations) {
            if (declaration.validate()) {
                jsClassBuilder.build(resolver, declaration)
                initializerBuilder.addType(declaration)
                initializerBuilder.addWriter(declaration)
            } else {
                nonProcessedSymbols.add(declaration)
            }
        }

        val apiDeclarations = resolver.findJsApiClasses()

        for (declaration in apiDeclarations) {
            if (declaration.validate()) {
                jsApiClassBuilder.build(resolver, declaration)
                initializerBuilder.addType(declaration)
            } else {
                nonProcessedSymbols.add(declaration)
            }
        }

        val apiFunctionClassDeclarations = resolver.findJsApiFunctionsClasses()

        for (declaration in apiFunctionClassDeclarations) {
            if (declaration.validate()) {
                jsApiFunctionBuilder.build(resolver, declaration)
            } else {
                nonProcessedSymbols.add(declaration)
            }
        }

        val functionFilesDeclarations = resolver.findJsFunctionsFiles()

        for (declaration in functionFilesDeclarations) {
            if (declaration.validate()) {
                jsFunctionBuilder.build(resolver, declaration)
                initializerBuilder.addWriter(declaration)
            } else {
                nonProcessedSymbols.add(declaration)
            }
        }

        val noPendingDeclarations = (functionFilesDeclarations
                + apiFunctionClassDeclarations
                + apiDeclarations
                + classDeclarations
        ).toList().isEmpty()

        if (noPendingDeclarations && nonProcessedSymbols.isEmpty()) {
            initializerBuilder.build(resolver)
        }

        return nonProcessedSymbols
    }
}