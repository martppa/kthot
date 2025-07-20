package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.EqualityOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.NotEquals

class NotEqualsComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : EqualityComparison() {
    override val operator: EqualityOperator = NotEquals
}

infix fun Operable.neq(rightHand: Operable): NotEqualsComparison = NotEqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Operation.neq(rightHand: Operable): NotEqualsComparison = NotEqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)