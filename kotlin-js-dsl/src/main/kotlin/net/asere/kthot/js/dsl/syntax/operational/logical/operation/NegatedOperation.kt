package net.asere.kthot.js.dsl.syntax.operational.logical.operation

import net.asere.kthot.js.dsl.syntax.operational.Operation
import net.asere.kthot.js.dsl.syntax.operational.Operator
import net.asere.kthot.js.dsl.syntax.operational.ReflexiveOperation
import net.asere.kthot.js.dsl.syntax.operational.logical.operation.operator.Negate

class NegatedOperation<T : Operation>(
    internal val comparison: T,
) : ReflexiveOperation() {
    override val leftSideElement: Operator = Negate
    override val rightSideElement: Operation = comparison
}