package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.EqualityOperator
import net.asere.kotlin.js.dsl.syntax.comparison.operator.Equals

class EqualsComparison(
    override val leftHand: Comparable,
    override val rightHand: Comparable,
) : EqualityComparison() {
    override val operator: EqualityOperator = Equals
}

infix fun Comparable.eq(rightHand: Comparable): EqualsComparison = EqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Comparison.eq(rightHand: Comparable): EqualsComparison = EqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)