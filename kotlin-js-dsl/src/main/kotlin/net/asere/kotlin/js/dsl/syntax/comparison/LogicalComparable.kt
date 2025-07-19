package net.asere.kotlin.js.dsl.syntax.comparison

import net.asere.kotlin.js.dsl.syntax.comparison.operator.NegatedComparable

interface LogicalComparable : Comparable

operator fun LogicalComparable.not(): Comparable = if (this is NegatedComparable<*>)
    comparable
else
    NegatedComparable(this)