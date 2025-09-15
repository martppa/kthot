package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.operator.Plus
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.type.string.JsString

class ConcatOperation(
    override val leftHand: JsString,
    override val rightHand: Operable,
) : ArithmeticalOperation(), JsString {
    override val operator: ArithmeticalOperator = Plus
}