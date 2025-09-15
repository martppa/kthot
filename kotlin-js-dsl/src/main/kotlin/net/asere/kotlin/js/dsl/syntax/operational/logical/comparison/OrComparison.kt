package net.asere.kotlin.js.dsl.syntax.operational.logical.comparison

import net.asere.kotlin.js.dsl.syntax.group.group
import net.asere.kotlin.js.dsl.syntax.group.groupIfGroupable
import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.logical.operator.LogicalOperator
import net.asere.kotlin.js.dsl.syntax.operational.logical.comparison.operator.Or

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

infix fun CompoundOperation.or(rightHand: Operable): OrComparison = OrComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfGroupable()
)