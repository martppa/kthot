package net.asere.kthot.js.dsl.type.number

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.JsElement

class JsNumberSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsNumber>(value), JsNumber {
    internal constructor(value: JsElement) : this("$value")
}

fun JsNumber.Companion.syntax(value: String): JsNumber = JsNumberSyntax(value)
fun JsNumber.Companion.syntax(value: JsElement): JsNumber = JsNumberSyntax(value)