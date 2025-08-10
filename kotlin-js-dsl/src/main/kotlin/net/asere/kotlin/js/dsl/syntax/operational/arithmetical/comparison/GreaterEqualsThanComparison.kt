package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison

import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.Operation
import net.asere.kotlin.js.dsl.syntax.operational.group
import net.asere.kotlin.js.dsl.syntax.operational.groupIfComparison
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation.operator.GreaterEqualsThan
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.syntax

class GreaterEqualsThanComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalComparison() {
    override val operator: ArithmeticalOperator = GreaterEqualsThan
}

infix fun Operable.gte(rightHand: Operable): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Operation.gte(rightHand: Operable): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)

infix fun Operable.gte(rightHand: Number): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this,
    rightHand = JsNumber.syntax("$rightHand")
)

infix fun Operation.gte(rightHand: Number): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this.group(),
    rightHand = JsNumber.syntax("$rightHand")
)