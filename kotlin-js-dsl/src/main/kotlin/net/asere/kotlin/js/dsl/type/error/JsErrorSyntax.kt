package net.asere.kotlin.js.dsl.type.error

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsErrorSyntax internal constructor(value: String) : JsReferenceSyntax<JsError>(value), JsError {
    internal constructor(value: JsElement) : this("$value")
}

fun JsError.Companion.syntax(value: String): JsErrorSyntax = JsErrorSyntax(value)