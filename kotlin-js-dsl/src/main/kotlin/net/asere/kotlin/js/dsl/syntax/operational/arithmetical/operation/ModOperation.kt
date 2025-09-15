package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation

import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.operator.Mod
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.type.number.JsNumber

class ModOperation(
    override val leftHand: JsNumber,
    override val rightHand: JsNumber,
) : ArithmeticalOperation() {
    override val operator: ArithmeticalOperator = Mod
}