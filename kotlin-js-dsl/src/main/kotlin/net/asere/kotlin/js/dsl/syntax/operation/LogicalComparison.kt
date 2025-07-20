package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.LogicalOperator

abstract class LogicalComparison : CompoundOperation() {
    abstract override val operator: LogicalOperator
}