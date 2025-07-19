package net.asere.kotlin.js.dsl.syntax.comparison.operator

import net.asere.kotlin.js.dsl.syntax.comparison.Comparable
import net.asere.kotlin.js.dsl.syntax.comparison.Comparison

class NegatedComparison<T : Comparison>(
    internal val comparison: T,
) : Comparison() {

    override val leftHand: Comparable get() = comparison.leftHand
    override val rightHand: Comparable get() = comparison.rightHand
    override val operator: Operator get() = comparison.operator

    override fun present(): String = "!($comparison)"
}