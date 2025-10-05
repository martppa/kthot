package net.asere.kthot.js.dsl.syntax.operational.equality.comparison

import net.asere.kthot.js.dsl.syntax.operational.CompoundOperation
import net.asere.kthot.js.dsl.syntax.operational.equality.operator.EqualityOperator

abstract class EqualityComparison : CompoundOperation() {
    abstract override val operator: EqualityOperator
}