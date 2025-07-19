package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.InstanceOf
import net.asere.kotlin.js.dsl.syntax.comparison.operator.Operator

class InstanceOfComparison(
    override val leftHand: Comparable,
    override val rightHand: Comparable,
) : Comparison() {
    override val operator: Operator = InstanceOf
}

infix fun Comparable.instanceOf(rightHand: Comparable): InstanceOfComparison = InstanceOfComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Comparison.instanceOf(rightHand: Comparable): InstanceOfComparison = InstanceOfComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)