package net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison

import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.Operation
import net.asere.kotlin.js.dsl.syntax.operational.group
import net.asere.kotlin.js.dsl.syntax.operational.groupIfComparison
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation.operator.LessEqualsThan
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.syntax

class LesserEqualsThanComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalComparison() {
    override val operator: ArithmeticalOperator = LessEqualsThan
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