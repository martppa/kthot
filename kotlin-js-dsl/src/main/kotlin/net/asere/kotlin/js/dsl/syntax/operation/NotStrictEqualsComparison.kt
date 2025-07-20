package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.EqualityOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.NotStrictEquals

class NotStrictEqualsComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : EqualityComparison() {
    override val operator: EqualityOperator = NotStrictEquals
}

infix fun Operable.nseq(rightHand: Operable): NotStrictEqualsComparison = NotStrictEqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Operation.nseq(rightHand: Operable): NotStrictEqualsComparison = NotStrictEqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)