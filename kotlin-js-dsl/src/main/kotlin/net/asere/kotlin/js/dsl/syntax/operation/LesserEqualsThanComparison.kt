package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.LesserEqualsThan
import net.asere.kotlin.js.dsl.type.bool.syntax
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.JsNumberSyntax
import net.asere.kotlin.js.dsl.type.number.syntax

class LesserEqualsThanComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalComparison() {
    override val operator: ArithmeticalOperator = LesserEqualsThan
}

infix fun Operable.lte(rightHand: Operable): LesserEqualsThanComparison = LesserEqualsThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun CompoundOperation.lte(rightHand: Operable): LesserEqualsThanComparison = LesserEqualsThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)

infix fun Operable.lte(rightHand: Number): LesserEqualsThanComparison = LesserEqualsThanComparison(
    leftHand = this,
    rightHand = JsNumber.syntax("$rightHand")
)

infix fun Operation.lte(rightHand: Number): LesserEqualsThanComparison = LesserEqualsThanComparison(
    leftHand = this.group(),
    rightHand = JsNumber.syntax("$rightHand")
)