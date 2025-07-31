package net.asere.kotlin.js.dsl.type.number

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsNumberSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsNumber>(value), JsNumber {
    internal constructor(value: JsElement) : this("$value")
}

fun JsNumber.Companion.syntax(value: String): JsNumberSyntax = JsNumberSyntax(value)