package net.asere.kthot.js.dsl.ksp.processor.api

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class JsApiProcessorProvider : SymbolProcessorProvider {

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return JsApiProcessor(
            codeGenerator = environment.codeGenerator,
            logger = environment.logger
        )
    }
}