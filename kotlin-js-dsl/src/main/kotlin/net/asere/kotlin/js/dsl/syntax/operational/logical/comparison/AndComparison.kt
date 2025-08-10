package net.asere.kotlin.js.dsl.syntax.operational.logical.comparison

import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.Operation
import net.asere.kotlin.js.dsl.syntax.operational.group
import net.asere.kotlin.js.dsl.syntax.operational.groupIfComparison
import net.asere.kotlin.js.dsl.syntax.operational.logical.comparison.operator.And
import net.asere.kotlin.js.dsl.syntax.operational.logical.operator.LogicalOperator

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