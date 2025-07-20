package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.GreaterThan
import net.asere.kotlin.js.dsl.value.JsValue

class GreaterThanComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalComparison() {
    override val operator: ArithmeticalOperator = GreaterThan
}

infix fun Operable.gt(rightHand: Operable): GreaterThanComparison = GreaterThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Operation.gt(rightHand: Operable): GreaterThanComparison = GreaterThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)