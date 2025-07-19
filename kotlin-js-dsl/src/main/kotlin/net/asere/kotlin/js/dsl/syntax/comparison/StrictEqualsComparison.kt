package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.EqualityOperator
import net.asere.kotlin.js.dsl.syntax.comparison.operator.Equals
import net.asere.kotlin.js.dsl.syntax.comparison.operator.StrictEquals

class StrictEqualsComparison(
    override val leftHand: Comparable,
    override val rightHand: Comparable,
) : EqualityComparison() {
    override val operator: EqualityOperator = StrictEquals
}

infix fun Comparable.seq(rightHand: Comparable): StrictEqualsComparison = StrictEqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Comparison.seq(rightHand: Comparable): StrictEqualsComparison = StrictEqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)