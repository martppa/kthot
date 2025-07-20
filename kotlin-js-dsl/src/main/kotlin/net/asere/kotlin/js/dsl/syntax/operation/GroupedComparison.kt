package net.asere.kotlin.js.dsl.syntax.operation

import net.asere.kotlin.js.dsl.syntax.operation.operator.Operator

class GroupedComparison<T : Operation>(
    internal val nested: T
) : Operation() {
    override val leftHand: Operable get() = nested.leftHand
    override val rightHand: Operable get() = nested.rightHand
    override val operator: Operator get() = nested.operator
    override val value: String = "($nested)"
}

fun <T : Operation> T.group(): GroupedComparison<T> = GroupedComparison(this)

fun Operable.groupIfComparison() = if (this is Operation) this.group() else this