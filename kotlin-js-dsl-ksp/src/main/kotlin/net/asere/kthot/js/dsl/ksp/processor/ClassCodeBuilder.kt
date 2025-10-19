package net.asere.kthot.js.dsl.ksp.processor

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration

interface ClassCodeBuilder {
    fun build(resolver: Resolver, declaration: KSClassDeclaration)
}