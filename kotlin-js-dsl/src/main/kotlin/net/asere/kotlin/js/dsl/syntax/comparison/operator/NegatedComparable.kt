package net.asere.kotlin.js.dsl.syntax.comparison.operator

import net.asere.kotlin.js.dsl.syntax.comparison.Comparable
import net.asere.kotlin.js.dsl.syntax.comparison.LogicalComparable

class NegatedComparable<T : Comparable>(
    internal val comparable: T,
) : LogicalComparable {
    override fun present(): String = "!$comparable"
    override fun toString() = present()
}