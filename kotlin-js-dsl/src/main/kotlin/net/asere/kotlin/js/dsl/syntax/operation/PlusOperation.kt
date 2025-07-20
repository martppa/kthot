package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.Plus

class PlusOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalOperation() {
    override val operator: ArithmeticalOperator = Plus
}

operator fun Operable.plus(rightHand: Operable): PlusOperation = PlusOperation(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

operator fun Operation.plus(rightHand: Operable): PlusOperation = PlusOperation(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)