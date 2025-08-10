package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator

abstract class ArithmeticalOperation : CompoundOperation() {
    abstract override val operator: ArithmeticalOperator
}