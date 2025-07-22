package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.GreaterThan
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax

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

infix fun CompoundOperation.gt(rightHand: Operable): GreaterThanComparison = GreaterThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)

infix fun Operable.gt(rightHand: Number): GreaterThanComparison = GreaterThanComparison(
    leftHand = this,
    rightHand = JsNumberSyntax("$rightHand")
)

infix fun Operation.gt(rightHand: Number): GreaterThanComparison = GreaterThanComparison(
    leftHand = this.group(),
    rightHand = JsNumberSyntax("$rightHand")
)