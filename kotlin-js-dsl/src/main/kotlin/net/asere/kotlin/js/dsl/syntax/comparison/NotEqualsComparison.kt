package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.EqualityOperator
import net.asere.kotlin.js.dsl.syntax.comparison.operator.NotEquals

class NotEqualsComparison(
    override val leftHand: Comparable,
    override val rightHand: Comparable,
) : EqualityComparison() {
    override val operator: EqualityOperator = NotEquals
}

infix fun Comparable.neq(rightHand: Comparable): NotEqualsComparison = NotEqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Comparison.neq(rightHand: Comparable): NotEqualsComparison = NotEqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)