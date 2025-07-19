package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.comparison.operator.GreaterEqualsThan

class GreaterEqualsThanComparison(
    override val leftHand: Comparable,
    override val rightHand: Comparable,
) : ArithmeticalComparison() {
    override val operator: ArithmeticalOperator = GreaterEqualsThan
}

infix fun Comparable.gte(rightHand: Comparable): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Comparison.gte(rightHand: Comparable): GreaterEqualsThanComparison = GreaterEqualsThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)