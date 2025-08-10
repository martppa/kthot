package net.asere.kotlin.js.dsl.syntax.operational.logical

import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.syntax.operational.ReflexiveOperation
import net.asere.kotlin.js.dsl.syntax.operational.logical.operation.operator.Negate
import net.asere.kotlin.js.dsl.syntax.operational.Operator

class NegatedOperable<T : Operable>(
    internal val operable: T,
) : ReflexiveOperation() {
    override val leftSideElement: Operator = Negate
    override val rightSideElement: T = operable
}