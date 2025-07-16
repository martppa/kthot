package net.asere.kotlin.js.dsl.declaration

sealed interface DeclarationType

data object Constant : DeclarationType
data object Mutable: DeclarationType