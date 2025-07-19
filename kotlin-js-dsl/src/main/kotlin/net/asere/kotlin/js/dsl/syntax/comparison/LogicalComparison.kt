package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.LogicalOperator

abstract class LogicalComparison : Comparison() {
    abstract override val operator: LogicalOperator
}