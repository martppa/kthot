package net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison.operator.Times
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kthot.js.dsl.type.number.JsNumber

class TimesOperation(
    override val leftHand: JsNumber,
    override val rightHand: JsNumber,
) : ArithmeticalOperation(), JsNumber {
    override val operator: ArithmeticalOperator = Times
}