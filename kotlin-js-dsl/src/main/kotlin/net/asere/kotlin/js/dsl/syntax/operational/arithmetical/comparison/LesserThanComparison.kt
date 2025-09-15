package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison

import net.asere.kotlin.js.dsl.syntax.group.group
import net.asere.kotlin.js.dsl.syntax.group.groupIfGroupable
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.Operation
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation.operator.LessThan
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.syntax

class LesserThanComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalComparison() {
    override val operator: ArithmeticalOperator = LessThan
}

infix fun Operable.lt(rightHand: Operable): LesserThanComparison = LesserThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfGroupable()
)

infix fun Operation.lt(rightHand: Operable): LesserThanComparison = LesserThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfGroupable()
)

infix fun Operable.lt(rightHand: Number): LesserThanComparison = LesserThanComparison(
    leftHand = this,
    rightHand = JsNumber.syntax("$rightHand")
)

infix fun Operation.lt(rightHand: Number): LesserThanComparison = LesserThanComparison(
    leftHand = this.group(),
    rightHand = JsNumber.syntax("$rightHand")
)