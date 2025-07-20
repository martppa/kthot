package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.InstanceOf
import net.asere.kotlin.js.dsl.syntax.operation.operator.Operator

class InstanceOfComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : Operation() {
    override val operator: Operator = InstanceOf
}

infix fun Operable.instanceOf(rightHand: Operable): InstanceOfComparison = InstanceOfComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Operation.instanceOf(rightHand: Operable): InstanceOfComparison = InstanceOfComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)