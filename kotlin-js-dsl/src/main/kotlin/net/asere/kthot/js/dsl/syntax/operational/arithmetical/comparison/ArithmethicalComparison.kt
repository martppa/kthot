package net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison

import net.asere.kthot.js.dsl.syntax.operational.ComparisonOperation
import net.asere.kthot.js.dsl.syntax.operational.CompoundOperation
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator

abstract class ArithmeticalCompoundComparison : CompoundOperation(), ComparisonOperation {
    abstract override val operator: ArithmeticalOperator
}