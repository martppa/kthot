package net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison

import net.asere.kthot.js.dsl.syntax.group.group
import net.asere.kthot.js.dsl.syntax.group.groupIfGroupable
import net.asere.kthot.js.dsl.syntax.operational.Operable
import net.asere.kthot.js.dsl.syntax.operational.Operation
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation.operator.LessThan
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.syntax

class LesserThanComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalCompoundComparison() {
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