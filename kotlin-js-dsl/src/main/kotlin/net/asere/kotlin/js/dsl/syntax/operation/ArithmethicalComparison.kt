package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator

abstract class ArithmeticalComparison : Operation() {
    abstract override val operator: ArithmeticalOperator
}