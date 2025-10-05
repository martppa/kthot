package net.asere.kthot.js.dsl.syntax.operational.equality.comparison

import net.asere.kthot.js.dsl.syntax.group.group
import net.asere.kthot.js.dsl.syntax.group.groupIfGroupable
import net.asere.kthot.js.dsl.syntax.operational.CompoundOperation
import net.asere.kthot.js.dsl.syntax.operational.Operable
import net.asere.kthot.js.dsl.syntax.operational.equality.operator.EqualityOperator
import net.asere.kthot.js.dsl.syntax.operational.equality.operator.StrictEquals

class StrictEqualsComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : EqualityComparison() {
    override val operator: EqualityOperator = StrictEquals
}

infix fun Operable.seq(rightHand: Operable): StrictEqualsComparison = StrictEqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfGroupable()
)

infix fun CompoundOperation.seq(rightHand: Operable): StrictEqualsComparison = StrictEqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfGroupable()
)