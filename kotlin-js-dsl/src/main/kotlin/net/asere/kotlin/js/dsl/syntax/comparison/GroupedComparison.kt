package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.Operator

class GroupedComparison<T : Comparison>(
    internal val nested: T
) : Comparison() {
    override val leftHand: Comparable get() = nested.leftHand
    override val rightHand: Comparable get() = nested.rightHand
    override val operator: Operator get() = nested.operator
    override val value: String = "($nested)"
}

fun <T : Comparison> T.group(): GroupedComparison<T> = GroupedComparison(this)

fun Comparable.groupIfComparison() = if (this is Comparison) this.group() else this