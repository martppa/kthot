package net.asere.kthot.js.dsl.type.date

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.instantiation.InstantiationOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsDateSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsDate>(value), JsDate {
    internal constructor(value: JsElement) : this("$value")
}

fun JsDate.Companion.syntax(value: String): JsDate =
    JsDateSyntax(value)

fun JsDate.Companion.syntax(value: JsElement): JsDate =
    JsDateSyntax(value)

/**
 * Constructs a new Date instance (e.g., `new Date()` or `new Date(year, month, ...)`).
 */
fun JsDate.Companion.new(vararg args: JsValue): JsDate =
    JsDate.syntax(InstantiationOperation(InvocationOperation("Date", *args)))