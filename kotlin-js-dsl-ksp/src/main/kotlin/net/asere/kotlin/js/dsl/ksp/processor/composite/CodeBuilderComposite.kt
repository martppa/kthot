package net.asere.kotlin.js.dsl.ksp.processor.composite

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import net.asere.kotlin.js.dsl.ksp.processor.CodeBuilder

class CodeBuilderComposite(
    private vararg val builders: CodeBuilder
) : CodeBuilder {

    override fun build(
        resolver: Resolver,
        declaration: KSClassDeclaration
    ) {
        builders.forEach { it.build(resolver, declaration) }
    }
}