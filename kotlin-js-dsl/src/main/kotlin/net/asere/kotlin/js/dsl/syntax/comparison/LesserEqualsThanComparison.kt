package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.comparison.operator.LesserEqualsThan

class LesserEqualsThanComparison(
    override val leftHand: Comparable,
    override val rightHand: Comparable,
) : ArithmeticalComparison() {
    override val operator: ArithmeticalOperator = LesserEqualsThan
}

infix fun Comparable.lte(rightHand: Comparable): LesserEqualsThanComparison = LesserEqualsThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Comparison.lte(rightHand: Comparable): LesserEqualsThanComparison = LesserEqualsThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)