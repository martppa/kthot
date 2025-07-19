package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.EqualityOperator
import net.asere.kotlin.js.dsl.syntax.comparison.operator.NotStrictEquals

class NotStrictEqualsComparison(
    override val leftHand: Comparable,
    override val rightHand: Comparable,
) : EqualityComparison() {
    override val operator: EqualityOperator = NotStrictEquals
}

infix fun Comparable.nseq(rightHand: Comparable): NotStrictEqualsComparison = NotStrictEqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Comparison.nseq(rightHand: Comparable): NotStrictEqualsComparison = NotStrictEqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)