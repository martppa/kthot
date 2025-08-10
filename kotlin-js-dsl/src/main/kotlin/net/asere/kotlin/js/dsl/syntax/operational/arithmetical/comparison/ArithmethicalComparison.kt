package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison

import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.type.bool.JsBoolean

abstract class ArithmeticalComparison : CompoundOperation(), JsBoolean {
    abstract override val operator: ArithmeticalOperator
}