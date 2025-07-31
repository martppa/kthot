package net.asere.kotlin.js.dsl.ksp.processor

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class JsInterfaceProcessorProvider : SymbolProcessorProvider {

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return JsInterfaceProcessor(
            codeGenerator = environment.codeGenerator,
            logger = environment.logger
        )
    }
}