package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator

abstract class ArithmeticalComparison : CompoundOperation() {
    abstract override val operator: ArithmeticalOperator
}