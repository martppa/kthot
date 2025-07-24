package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.LesserThan
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.types.type.JsNumber

class LesserThanComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalComparison() {
    override val operator: ArithmeticalOperator = LesserThan
}

infix fun Operable.lt(rightHand: Operable): LesserThanComparison = LesserThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Operation.lt(rightHand: Operable): LesserThanComparison = LesserThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)

infix fun Operable.lt(rightHand: Number): LesserThanComparison = LesserThanComparison(
    leftHand = this,
    rightHand = JsNumberSyntax("$rightHand")
)

infix fun Operation.lt(rightHand: Number): LesserThanComparison = LesserThanComparison(
    leftHand = this.group(),
    rightHand = JsNumberSyntax("$rightHand")
)