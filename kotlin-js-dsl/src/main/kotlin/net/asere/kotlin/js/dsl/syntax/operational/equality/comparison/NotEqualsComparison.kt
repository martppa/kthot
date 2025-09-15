package net.asere.kotlin.js.dsl.syntax.operational.equality.comparison

import net.asere.kotlin.js.dsl.syntax.group.group
import net.asere.kotlin.js.dsl.syntax.group.groupIfGroupable
import net.asere.kotlin.js.dsl.syntax.operational.CompoundOperation
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.equality.operator.EqualityOperator
import net.asere.kotlin.js.dsl.syntax.operational.equality.operator.NotEquals

class NotEqualsComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : EqualityComparison() {
    override val operator: EqualityOperator = NotEquals
}

infix fun Operable.neq(rightHand: Operable): NotEqualsComparison = NotEqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfGroupable()
)

infix fun CompoundOperation.neq(rightHand: Operable): NotEqualsComparison = NotEqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfGroupable()
)