package net.asere.kotlin.js.dsl.syntax.operational.logical.operation

import net.asere.kotlin.js.dsl.syntax.operational.Operation
import net.asere.kotlin.js.dsl.syntax.operational.ReflexiveOperation
import net.asere.kotlin.js.dsl.syntax.operational.group
import net.asere.kotlin.js.dsl.syntax.operational.logical.operation.operator.Negate
import net.asere.kotlin.js.dsl.syntax.operational.Operator

class NegatedOperation<T : Operation>(
    internal val comparison: T,
) : ReflexiveOperation() {
    override val leftSideElement: Operator = Negate
    override val rightSideElement: Operation = comparison.group()
}