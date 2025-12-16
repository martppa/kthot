package net.asere.kthot.js.dsl.syntax.operational.equality.comparison

import net.asere.kthot.js.dsl.syntax.group.group
import net.asere.kthot.js.dsl.syntax.group.groupIfGroupable
import net.asere.kthot.js.dsl.syntax.operational.Operable
import net.asere.kthot.js.dsl.syntax.operational.Operation
import net.asere.kthot.js.dsl.syntax.operational.equality.operator.EqualityOperator
import net.asere.kthot.js.dsl.syntax.operational.equality.operator.Equals
import net.asere.kthot.js.dsl.type.bool.JsBoolean

class EqualsComparison(
    override val leftHand: Operable,
    override val rightHand: Operable,
) : EqualityComparison() {
    override val operator: EqualityOperator = Equals
}

infix fun Operable.eq(rightHand: Operable): EqualsComparison = EqualsComparison(
    leftHand = this,
    rightHand = rightHand.groupIfGroupable()
)

infix fun Operation.eq(rightHand: Operable): EqualsComparison = EqualsComparison(
    leftHand = this.group(),
    rightHand = rightHand.groupIfGroupable()
)