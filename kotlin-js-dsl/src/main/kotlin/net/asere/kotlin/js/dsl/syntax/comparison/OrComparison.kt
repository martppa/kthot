package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.LogicalOperator
import net.asere.kotlin.js.dsl.syntax.comparison.operator.Or

class OrComparison(
    override val leftHand: Comparable,
    override val rightHand: Comparable,
) : LogicalComparison() {
    override val operator: LogicalOperator = Or
}

infix fun Comparable.or(rightHand: Comparable): OrComparison = OrComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Comparison.or(rightHand: Comparable): OrComparison = OrComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)