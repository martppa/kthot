package net.asere.kotlin.js.dsl.type.error

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsErrorSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsError>(value, isNullable), JsError {
    internal constructor(value: JsElement, isNullable: Boolean = false) : this("$value", isNullable)
}

fun JsError.Companion.syntax(value: String, isNullable: Boolean = false): JsErrorSyntax =
    JsErrorSyntax(value, isNullable)