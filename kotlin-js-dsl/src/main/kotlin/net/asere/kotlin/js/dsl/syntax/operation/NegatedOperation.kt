package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.Operator

class NegatedOperation<T : Operation>(
    internal val comparison: T,
) : Operation() {

    override val leftHand: Operable get() = comparison.leftHand
    override val rightHand: Operable get() = comparison.rightHand
    override val operator: Operator get() = comparison.operator

    override fun present(): String = "!($comparison)"
}