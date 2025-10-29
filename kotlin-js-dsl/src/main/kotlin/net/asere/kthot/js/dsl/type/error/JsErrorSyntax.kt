package net.asere.kthot.js.dsl.type.error

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsErrorSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsError>(value), JsError {
    internal constructor(value: JsElement) : this("$value")
}

fun JsError.Companion.syntax(value: String): JsError =
    JsErrorSyntax(value)

fun JsError.Companion.syntax(value: JsElement): JsError =
    JsErrorSyntax(value)