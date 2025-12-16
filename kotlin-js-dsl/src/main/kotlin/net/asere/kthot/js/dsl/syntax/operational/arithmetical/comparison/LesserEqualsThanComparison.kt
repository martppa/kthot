package net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison

import net.asere.kthot.js.dsl.syntax.group.group
import net.asere.kthot.js.dsl.syntax.group.groupIfGroupable
import net.asere.kthot.js.dsl.syntax.operational.CompoundOperation
import net.asere.kthot.js.dsl.syntax.operational.Operable
import net.asere.kthot.js.dsl.syntax.operational.Operation
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operator.ArithmeticalOperator
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation.operator.LessEqualsThan
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.syntax

class LesserEqualsThanComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : ArithmeticalCompoundComparison() {
    override val operator: ArithmeticalOperator = LessEqualsThan
}

infix fun Operable.lte(rightHand: Operable): LesserEqualsThanComparison = LesserEqualsThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfGroupable()
)

infix fun CompoundOperation.lte(rightHand: Operable): LesserEqualsThanComparison = LesserEqualsThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfGroupable()
)

infix fun Operable.lte(rightHand: Number): LesserEqualsThanComparison = LesserEqualsThanComparison(
    leftHand = this,
    rightHand = JsNumber.syntax("$rightHand")
)

infix fun Operation.lte(rightHand: Number): LesserEqualsThanComparison = LesserEqualsThanComparison(
    leftHand = this.group(),
    rightHand = JsNumber.syntax("$rightHand")
)