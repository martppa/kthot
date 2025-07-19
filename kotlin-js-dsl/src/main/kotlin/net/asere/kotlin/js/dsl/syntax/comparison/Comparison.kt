package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.NegatedComparison
import net.asere.kotlin.js.dsl.syntax.comparison.operator.Operator

abstract class Comparison : ComparableSyntax() {

    internal abstract val leftHand: Comparable
    internal abstract val rightHand: Comparable
    internal abstract val operator: Operator

    override val value: String get() {
        val stringBuilder = StringBuilder()
        stringBuilder.append("$leftHand")
        stringBuilder.append(" $operator ")
        stringBuilder.append("$rightHand")
        return stringBuilder.toString()
    }
}

operator fun Comparison.not(): Comparison = if (this is NegatedComparison<*>)
    comparison
else
    NegatedComparison(this)