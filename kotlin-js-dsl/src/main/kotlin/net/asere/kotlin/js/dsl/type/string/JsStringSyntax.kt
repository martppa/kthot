package net.asere.kotlin.js.dsl.type.string

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsStringSyntax internal constructor(value: String) : JsReferenceSyntax<JsString>(value), JsString {
    internal constructor(value: JsElement) : this("$value")
}

fun JsString.Companion.syntax(value: String): JsString = JsStringSyntax(value)
fun JsString.Companion.syntax(value: JsElement): JsString = JsStringSyntax(value)