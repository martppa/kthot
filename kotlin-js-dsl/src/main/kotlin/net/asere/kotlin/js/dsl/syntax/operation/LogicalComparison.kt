package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.LogicalOperator

abstract class LogicalComparison : Operation() {
    abstract override val operator: LogicalOperator
}