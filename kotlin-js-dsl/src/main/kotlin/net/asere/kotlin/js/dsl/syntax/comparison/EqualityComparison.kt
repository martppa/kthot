package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.EqualityOperator

abstract class EqualityComparison : Comparison() {
    abstract override val operator: EqualityOperator
}