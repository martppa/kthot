package net.asere.kthot.js.dsl.ksp.processor.composite

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import net.asere.kthot.js.dsl.ksp.processor.ClassCodeBuilder

class CodeBuilderComposite(
    private vararg val builders: ClassCodeBuilder
) : ClassCodeBuilder {

    override fun build(
        resolver: Resolver,
        declaration: KSClassDeclaration
    ) {
        builders.forEach { it.build(resolver, declaration) }
    }
}