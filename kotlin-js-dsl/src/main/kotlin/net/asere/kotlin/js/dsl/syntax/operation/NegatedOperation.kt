package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.Negate
import net.asere.kotlin.js.dsl.syntax.operation.operator.Operator

class NegatedOperation<T : ReflexiveOperation>(
    internal val comparison: T,
) : ReflexiveOperation() {
    override val leftSideElement: Operator = Negate
    override val rightSideElement: Operation = comparison.group()

}