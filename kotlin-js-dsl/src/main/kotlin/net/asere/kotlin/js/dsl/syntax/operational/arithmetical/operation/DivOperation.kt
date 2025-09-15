package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.operator.Div
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.type.number.JsNumber

class DivOperation(
    override val leftHand: JsNumber,
    override val rightHand: JsNumber,
) : ArithmeticalOperation(), JsNumber {
    override val operator: ArithmeticalOperator = Div
}