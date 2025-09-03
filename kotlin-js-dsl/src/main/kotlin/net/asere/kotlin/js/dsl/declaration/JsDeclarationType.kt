package net.asere.kotlin.js.dsl.declaration

sealed interface DeclarationType {
    data object Const : DeclarationType
    data object Let: DeclarationType
    data object Var: DeclarationType
}