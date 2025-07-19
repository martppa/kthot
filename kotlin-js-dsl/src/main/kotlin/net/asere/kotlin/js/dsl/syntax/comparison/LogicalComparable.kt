package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.NegatedLogicalComparable

interface LogicalComparable : Comparable

operator fun LogicalComparable.not(): LogicalComparable = if (this is NegatedLogicalComparable<*>)
    comparable
else
    NegatedLogicalComparable(this)