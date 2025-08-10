package net.asere.kotlin.js.dsl.syntax.operational.equality.comparison

import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.equality.operator.EqualityOperator
import net.asere.kotlin.js.dsl.syntax.operational.equality.operator.StrictEquals
import net.asere.kotlin.js.dsl.syntax.operational.group
import net.asere.kotlin.js.dsl.syntax.operational.groupIfComparison

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