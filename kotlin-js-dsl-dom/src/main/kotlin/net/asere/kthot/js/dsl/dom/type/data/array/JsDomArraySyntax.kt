package net.asere.kthot.js.dsl.dom.type.data.array

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsDomArraySyntax internal constructor(value: String) :
    JsReferenceSyntax<JsDomArray>(value), JsDomArray {
    internal constructor(value: JsElement) : this("$value")
}

fun JsDomArray.Companion.syntax(value: String): JsDomArray =
    JsDomArraySyntax(value)

fun JsDomArray.Companion.syntax(value: JsElement): JsDomArray =
    JsDomArraySyntax(value)