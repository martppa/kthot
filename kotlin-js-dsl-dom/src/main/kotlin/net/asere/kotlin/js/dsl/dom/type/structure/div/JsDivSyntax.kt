package net.asere.kotlin.js.dsl.dom.type.structure.div

import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsDiv].
 */
class JsDivSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsDiv>(value, isNullable), JsDiv {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsDiv.Companion.syntax(value: String, isNullable: Boolean = false): JsDiv =
    JsDivSyntax(value, isNullable)

fun JsDiv.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsDiv =
    JsDivSyntax(value, isNullable)