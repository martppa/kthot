package net.asere.kthot.js.dsl.syntax.operational.logical.comparison

import net.asere.kthot.js.dsl.syntax.group.group
import net.asere.kthot.js.dsl.syntax.group.groupIfGroupable
import net.asere.kthot.js.dsl.syntax.operational.Operable
import net.asere.kthot.js.dsl.syntax.operational.Operation
import net.asere.kthot.js.dsl.syntax.operational.logical.comparison.operator.And
import net.asere.kthot.js.dsl.syntax.operational.logical.operator.LogicalOperator

class AndComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : LogicalComparison() {
    override val operator: LogicalOperator = And
}

infix fun Operable.and(rightHand: Operable): AndComparison = AndComparison(
    leftHand = this,
    rightHand = rightHand.groupIfGroupable()
)

infix fun Operation.and(rightHand: Operable): AndComparison = AndComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfGroupable()
)