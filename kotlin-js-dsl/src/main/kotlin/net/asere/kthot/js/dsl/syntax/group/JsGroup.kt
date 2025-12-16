@file:Suppress("TYPE_INTERSECTION_AS_REIFIED_WARNING")

package net.asere.kthot.js.dsl.syntax.group

import net.asere.kthot.js.dsl.syntax.operational.ArithmeticalOperation
import net.asere.kthot.js.dsl.syntax.operational.ComparisonOperation
import net.asere.kthot.js.dsl.syntax.operational.Operable
import net.asere.kthot.js.dsl.syntax.operational.Operation
import net.asere.kthot.js.dsl.type.JsElement

fun ArithmeticalOperation.group() = ArithmeticalOperation.anonymous(JsGroupSyntax(this))
fun ComparisonOperation.group() = ComparisonOperation.anonymous(JsGroupSyntax(this))
fun Operation.group() = Operation.anonymous(JsGroupSyntax(this))

inline fun <reified T : Operable> T.groupIfGroupable(): Operable = when (this) {
    is ArithmeticalOperation -> group()
    is ComparisonOperation -> group()
    is Operation -> group()
    else -> this
}

inline fun <reified T : JsElement> T.groupIfGroupable(): JsElement = when (this) {
    is ArithmeticalOperation -> group()
    is ComparisonOperation -> group()
    is Operation -> group()
    else -> this
}