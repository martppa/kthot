package net.asere.kotlin.js.dsl.type.string

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsStringSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsString>(value, isNullable), JsString {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)

    override fun stringify(): String = $$$"${$$${super.name}}"
}

fun JsString.Companion.syntax(value: String, isNullable: Boolean = false): JsString = JsStringSyntax(value, isNullable)
fun JsString.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsString =
    JsStringSyntax(value, isNullable)