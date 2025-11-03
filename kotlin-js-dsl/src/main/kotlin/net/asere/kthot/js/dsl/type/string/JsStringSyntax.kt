package net.asere.kthot.js.dsl.type.string

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.JsElement

class JsStringSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsString>(value), JsString {
    internal constructor(value: JsElement) : this("$value")

    override fun stringify(): String = $$$"${$$${super._name_}}"
}

fun JsString.Companion.syntax(value: String): JsString = JsStringSyntax(value)
fun JsString.Companion.syntax(value: JsElement): JsString =
    JsStringSyntax(value)