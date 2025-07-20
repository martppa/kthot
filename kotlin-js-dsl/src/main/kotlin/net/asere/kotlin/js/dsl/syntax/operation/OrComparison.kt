package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.LogicalOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.Or

class OrComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : LogicalComparison() {
    override val operator: LogicalOperator = Or
}

infix fun Operable.or(rightHand: Operable): OrComparison = OrComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Operation.or(rightHand: Operable): OrComparison = OrComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)