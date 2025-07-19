package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.ArithmeticalOperator

abstract class ArithmeticalComparison : Comparison() {
    abstract override val operator: ArithmeticalOperator
}