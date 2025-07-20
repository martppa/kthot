package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.And
import net.asere.kotlin.js.dsl.syntax.operation.operator.LogicalOperator

class AndComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : LogicalComparison() {
    override val operator: LogicalOperator = And
}

infix fun Operable.and(rightHand: Operable): AndComparison = AndComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Operation.and(rightHand: Operable): AndComparison = AndComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)