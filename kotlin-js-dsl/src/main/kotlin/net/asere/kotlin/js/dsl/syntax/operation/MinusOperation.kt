package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.Minus

class MinusOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalOperation() {
    override val operator: ArithmeticalOperator = Minus
}

operator fun Operable.minus(rightHand: Operable): PlusOperation = PlusOperation(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

operator fun Operation.minus(rightHand: Operable): PlusOperation = PlusOperation(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)