package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.EqualityOperator

abstract class EqualityComparison : CompoundOperation() {
    abstract override val operator: EqualityOperator
}