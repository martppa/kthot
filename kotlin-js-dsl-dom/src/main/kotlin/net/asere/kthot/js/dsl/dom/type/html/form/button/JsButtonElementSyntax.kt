package net.asere.kthot.js.dsl.dom.type.html.form.button


import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsButtonElement].
 */
class JsButtonElementSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsButtonElement>(value), JsButtonElement {
    internal constructor (value: JsElement) : this("$value")
}

fun JsButtonElement.Companion.syntax(value: String): JsButtonElement =
    JsButtonElementSyntax(value)

fun JsButtonElement.Companion.syntax(value: JsElement): JsButtonElement =
    JsButtonElementSyntax(value)