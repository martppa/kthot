package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.symbol.KSDeclaration

val KSDeclaration.fullName: String get() = qualifiedName?.asString() ?: "Any"