package net.asere.kthot.js.dsl.type.number

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsNumberSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsNumber>(value, isNullable), JsNumber {
    internal constructor(value: JsElement, isNullable: Boolean = false) : this("$value", isNullable)
}

fun JsNumber.Companion.syntax(value: String, isNullable: Boolean = false): JsNumber = JsNumberSyntax(value, isNullable)
fun JsNumber.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsNumber = JsNumberSyntax(value, isNullable)