package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.LesserEqualsThan
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax

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
    rightHand = JsNumberSyntax("$rightHand")
)

infix fun Operation.lte(rightHand: Number): LesserEqualsThanComparison = LesserEqualsThanComparison(
    leftHand = this.group(),
    rightHand = JsNumberSyntax("$rightHand")
)