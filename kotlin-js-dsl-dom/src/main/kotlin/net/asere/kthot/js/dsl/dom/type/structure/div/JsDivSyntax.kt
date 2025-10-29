package net.asere.kthot.js.dsl.dom.type.structure.div

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsDiv].
 */
class JsDivSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsDiv>(value), JsDiv {
    internal constructor(value: JsElement) : this("$value")
}

fun JsDiv.Companion.syntax(value: String): JsDiv =
    JsDivSyntax(value)

fun JsDiv.Companion.syntax(value: JsElement): JsDiv =
    JsDivSyntax(value)