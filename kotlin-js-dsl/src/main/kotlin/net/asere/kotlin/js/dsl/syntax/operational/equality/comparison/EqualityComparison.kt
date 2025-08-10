package net.asere.kotlin.js.dsl.syntax.operational.equality.comparison

import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.equality.operator.EqualityOperator

abstract class EqualityComparison : CompoundOperation() {
    abstract override val operator: EqualityOperator
}