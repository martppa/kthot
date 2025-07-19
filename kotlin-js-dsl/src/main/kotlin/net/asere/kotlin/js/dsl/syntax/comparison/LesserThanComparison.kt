package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.ArithmeticalOperator
import net.asere.kotlin.js.dsl.syntax.comparison.operator.LesserThan

class LesserThanComparison(
    override val leftHand: Comparable,
    override val rightHand: Comparable,
) : ArithmeticalComparison() {
    override val operator: ArithmeticalOperator = LesserThan
}

infix fun Comparable.lt(rightHand: Comparable): LesserThanComparison = LesserThanComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Comparison.lt(rightHand: Comparable): LesserThanComparison = LesserThanComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)