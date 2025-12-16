package net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison

import net.asere.kthot.js.dsl.syntax.group.group
import net.asere.kthot.js.dsl.syntax.group.groupIfGroupable
import net.asere.kthot.js.dsl.syntax.operational.Operable
import net.asere.kthot.js.dsl.syntax.operational.Operation
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation.operator.GreaterEqualsThan
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.syntax

class GreaterEqualsThanComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalCompoundComparison() {
    override val operator: ArithmeticalOperator = GreaterEqualsThan
}

infix fun Operable.gte(rightHand: Operable): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfGroupable()
)

infix fun Operation.gte(rightHand: Operable): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfGroupable()
)

infix fun Operable.gte(rightHand: Number): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this,
    rightHand = JsNumber.syntax("$rightHand")
)

infix fun Operation.gte(rightHand: Number): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this.group(),
    rightHand = JsNumber.syntax("$rightHand")
)