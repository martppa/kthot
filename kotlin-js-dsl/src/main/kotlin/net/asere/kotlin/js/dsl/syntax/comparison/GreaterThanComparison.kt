package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.comparison.operator.GreaterThan

class GreaterThanComparison(
    override val leftHand: Comparable,
    override val rightHand: Comparable,
) : ArithmeticalComparison() {
    override val operator: ArithmeticalOperator = GreaterThan
}

infix fun Comparable.gt(rightHand: Comparable): GreaterThanComparison = GreaterThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Comparison.gt(rightHand: Comparable): GreaterThanComparison = GreaterThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)