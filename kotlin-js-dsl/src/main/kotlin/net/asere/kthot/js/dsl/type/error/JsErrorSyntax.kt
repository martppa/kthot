package net.asere.kthot.js.dsl.type.error

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsErrorSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsError>(value, isNullable), JsError {
    internal constructor(value: JsElement, isNullable: Boolean = false) : this("$value", isNullable)
}

fun JsError.Companion.syntax(value: String, isNullable: Boolean = false): JsError =
    JsErrorSyntax(value, isNullable)

fun JsError.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsError =
    JsErrorSyntax(value, isNullable)