package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.EqualityOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.Equals

class EqualsComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : EqualityComparison() {
    override val operator: EqualityOperator = Equals
}

infix fun Operable.eq(rightHand: Operable): EqualsComparison = EqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Operation.eq(rightHand: Operable): EqualsComparison = EqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)