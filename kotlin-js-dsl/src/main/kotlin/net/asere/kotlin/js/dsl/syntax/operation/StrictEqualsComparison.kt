package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.EqualityOperator
import net.asere.kotlin.js.dsl.syntax.operation.operator.StrictEquals

class StrictEqualsComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : EqualityComparison() {
    override val operator: EqualityOperator = StrictEquals
}

infix fun Operable.seq(rightHand: Operable): StrictEqualsComparison = StrictEqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun CompoundOperation.seq(rightHand: Operable): StrictEqualsComparison = StrictEqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)