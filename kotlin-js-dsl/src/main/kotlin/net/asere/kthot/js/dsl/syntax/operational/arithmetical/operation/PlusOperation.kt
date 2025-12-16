package net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison.operator.Plus
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kthot.js.dsl.type.number.JsNumber

class PlusOperation(
    override val leftHand: JsNumber,
    override val rightHand: JsNumber,
) : ArithmeticalCompoundOperation(), JsNumber {
    override val operator: ArithmeticalOperator = Plus
}