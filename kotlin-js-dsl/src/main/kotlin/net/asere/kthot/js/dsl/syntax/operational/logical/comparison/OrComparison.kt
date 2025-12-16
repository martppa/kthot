package net.asere.kthot.js.dsl.syntax.operational.logical.comparison

import net.asere.kthot.js.dsl.syntax.group.group
import net.asere.kthot.js.dsl.syntax.group.groupIfGroupable
import net.asere.kthot.js.dsl.syntax.operational.Operable
import net.asere.kthot.js.dsl.syntax.operational.Operation
import net.asere.kthot.js.dsl.syntax.operational.logical.comparison.operator.Or
import net.asere.kthot.js.dsl.syntax.operational.logical.operator.LogicalOperator

class OrComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : LogicalComparison() {
    override val operator: LogicalOperator = Or
}

infix fun Operable.or(rightHand: Operable): OrComparison = OrComparison(
    leftHand = this,
    rightHand = rightHand.groupIfGroupable()
)

infix fun Operation.or(rightHand: Operable): OrComparison = OrComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfGroupable()
)