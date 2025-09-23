package net.asere.kotlin.js.dsl.dom.type.data.array

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsDomArraySyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsDomArray>(value, isNullable), JsDomArray {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsDomArray.Companion.syntax(value: String, isNullable: Boolean = false): JsDomArray =
    JsDomArraySyntax(value, isNullable)

fun JsDomArray.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsDomArray =
    JsDomArraySyntax(value, isNullable)