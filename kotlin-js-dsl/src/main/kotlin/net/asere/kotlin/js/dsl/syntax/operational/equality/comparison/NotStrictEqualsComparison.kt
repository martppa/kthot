package net.asere.kotlin.js.dsl.syntax.operational.equality.comparison

import net.asere.kotlin.js.dsl.syntax.group.group
import net.asere.kotlin.js.dsl.syntax.group.groupIfGroupable
import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.equality.operator.EqualityOperator
import net.asere.kotlin.js.dsl.syntax.operational.equality.operator.NotStrictEquals

class NotStrictEqualsComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : EqualityComparison() {
    override val operator: EqualityOperator = NotStrictEquals
}

infix fun Operable.nseq(rightHand: Operable): NotStrictEqualsComparison = NotStrictEqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfGroupable()
)

infix fun CompoundOperation.nseq(rightHand: Operable): NotStrictEqualsComparison = NotStrictEqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfGroupable()
)