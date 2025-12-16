package net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kthot.js.dsl.syntax.operational.ArithmeticalOperation
import net.asere.kthot.js.dsl.syntax.operational.CompoundOperation
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator

abstract class ArithmeticalCompoundOperation : CompoundOperation(), ArithmeticalOperation {
    abstract override val operator: ArithmeticalOperator
}