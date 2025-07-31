package net.asere.kotlin.js.dsl.dom.type.array

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsDomArraySyntax internal constructor(value: String) : JsReferenceSyntax<JsDomArray>(value), JsDomArray {
    internal constructor(value: JsElement) : this("$value")
}

fun JsDomArray.Companion.syntax(value: String): JsDomArraySyntax = JsDomArraySyntax(value)
fun JsDomArray.Companion.syntax(value: JsElement): JsDomArraySyntax = JsDomArraySyntax(value)