package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.Negate
import net.asere.kotlin.js.dsl.syntax.operation.operator.Operator

class NegatedOperable<T : Operable>(
    internal val operable: T,
) : ReflexiveOperation() {
    override val leftSideElement: Operator = Negate
    override val rightSideElement: T = operable
}