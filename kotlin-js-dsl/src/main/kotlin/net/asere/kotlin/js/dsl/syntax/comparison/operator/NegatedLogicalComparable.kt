package net.asere.kotlin.js.dsl.syntax.comparison.operator

import net.asere.kotlin.js.dsl.syntax.comparison.LogicalComparable

class NegatedLogicalComparable<T : LogicalComparable>(
    internal val comparable: T,
) : LogicalComparable {
    override fun present(): String = "!$comparable"
}