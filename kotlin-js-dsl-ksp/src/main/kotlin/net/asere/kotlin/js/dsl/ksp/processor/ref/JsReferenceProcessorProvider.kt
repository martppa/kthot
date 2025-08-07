package net.asere.kotlin.js.dsl.ksp.processor.ref

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class JsReferenceProcessorProvider : SymbolProcessorProvider {

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return JsReferenceProcessor(
            codeGenerator = environment.codeGenerator,
            logger = environment.logger
        )
    }
}