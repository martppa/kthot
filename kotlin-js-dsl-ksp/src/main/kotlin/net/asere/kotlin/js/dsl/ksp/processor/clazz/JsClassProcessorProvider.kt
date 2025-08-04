package net.asere.kotlin.js.dsl.ksp.processor.clazz

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class JsClassProcessorProvider : SymbolProcessorProvider {

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return JsClassProcessor(
            codeGenerator = environment.codeGenerator,
            logger = environment.logger
        )
    }
}