package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.EqualityOperator

abstract class EqualityComparison : Operation() {
    abstract override val operator: EqualityOperator
}