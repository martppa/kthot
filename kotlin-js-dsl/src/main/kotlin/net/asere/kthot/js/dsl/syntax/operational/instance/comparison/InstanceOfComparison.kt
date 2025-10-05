package net.asere.kthot.js.dsl.syntax.operational.instance.comparison

import net.asere.kthot.js.dsl.syntax.group.group
import net.asere.kthot.js.dsl.syntax.group.groupIfGroupable
import net.asere.kthot.js.dsl.syntax.operational.CompoundOperation
import net.asere.kthot.js.dsl.syntax.operational.Operable
import net.asere.kthot.js.dsl.syntax.operational.instance.operator.InstanceOf
import net.asere.kthot.js.dsl.syntax.operational.Operator

class InstanceOfComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : CompoundOperation() {
    override val operator: Operator = InstanceOf
}

infix fun Operable.instanceOf(rightHand: Operable): InstanceOfComparison = InstanceOfComparison(
    leftHand = this,
    rightHand = rightHand.groupIfGroupable()
)

infix fun CompoundOperation.instanceOf(rightHand: Operable): InstanceOfComparison = InstanceOfComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfGroupable()
)