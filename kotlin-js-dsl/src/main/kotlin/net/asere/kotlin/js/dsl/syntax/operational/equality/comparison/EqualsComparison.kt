package net.asere.kotlin.js.dsl.syntax.operational.equality.comparison

import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.Operation
import net.asere.kotlin.js.dsl.syntax.operational.equality.operator.EqualityOperator
import net.asere.kotlin.js.dsl.syntax.operational.equality.operator.Equals
import net.asere.kotlin.js.dsl.syntax.operational.group
import net.asere.kotlin.js.dsl.syntax.operational.groupIfComparison

class EqualsComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : EqualityComparison() {
    override val operator: EqualityOperator = Equals
}

infix fun Operable.eq(rightHand: Operable): EqualsComparison = EqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfComparison()
)

infix fun Operation.eq(rightHand: Operable): EqualsComparison = EqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfComparison()
)