package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.GreaterThan
import net.asere.kotlin.js.dsl.type.bool.syntax
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.JsNumberSyntax
import net.asere.kotlin.js.dsl.type.number.syntax

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
    rightHand = JsNumber.syntax("$rightHand")
)

infix fun Operation.gt(rightHand: Number): GreaterThanComparison = GreaterThanComparison(
    leftHand = this.group(),
    rightHand = JsNumber.syntax("$rightHand")
)