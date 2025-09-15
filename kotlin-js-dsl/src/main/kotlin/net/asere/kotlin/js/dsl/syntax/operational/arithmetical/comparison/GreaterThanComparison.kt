package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison

import net.asere.kotlin.js.dsl.syntax.group.group
import net.asere.kotlin.js.dsl.syntax.group.groupIfGroupable
import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.Operation
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation.operator.GreaterThan
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.syntax

class GreaterThanComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalComparison() {
    override val operator: ArithmeticalOperator = GreaterThan
}

infix fun Operable.gt(rightHand: Operable): GreaterThanComparison = GreaterThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfGroupable()
)

infix fun CompoundOperation.gt(rightHand: Operable): GreaterThanComparison = GreaterThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfGroupable()
)

infix fun Operable.gt(rightHand: Number): GreaterThanComparison = GreaterThanComparison(
    leftHand = this,
    rightHand = JsNumber.syntax("$rightHand")
)

infix fun Operation.gt(rightHand: Number): GreaterThanComparison = GreaterThanComparison(
    leftHand = this.group(),
    rightHand = JsNumber.syntax("$rightHand")
)