package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.Times

class TimesOperation(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalOperation() {
    override val operator: ArithmeticalOperator = Times
}

operator fun Operable.times(rightHand: Operable): TimesOperation = TimesOperation(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

operator fun Operation.times(rightHand: Operable): TimesOperation = TimesOperation(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)