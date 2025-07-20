package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.Div

class DivOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalOperation() {
    override val operator: ArithmeticalOperator = Div
}

operator fun Operable.div(rightHand: Operable): DivOperation = DivOperation(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

operator fun Operation.div(rightHand: Operable): DivOperation = DivOperation(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)