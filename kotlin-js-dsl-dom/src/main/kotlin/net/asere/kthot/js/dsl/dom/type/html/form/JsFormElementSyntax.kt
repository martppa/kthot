package net.asere.kthot.js.dsl.dom.type.html.form

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsFormElement].
 */
class JsFormElementSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsFormElement>(value), JsFormElement {
    internal constructor(value: JsElement) : this("$value")
}

fun JsFormElement.Companion.syntax(value: String): JsFormElement =
    JsFormElementSyntax(value)

fun JsFormElement.Companion.syntax(value: JsElement): JsFormElement =
    JsFormElementSyntax(value)