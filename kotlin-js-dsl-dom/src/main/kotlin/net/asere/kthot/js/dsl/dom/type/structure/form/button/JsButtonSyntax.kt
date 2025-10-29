package net.asere.kthot.js.dsl.dom.type.structure.form.button


import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsButton].
 */
class JsButtonSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsButton>(value), JsButton {
    internal constructor (value: JsElement) : this("$value")
}

fun JsButton.Companion.syntax(value: String): JsButton =
    JsButtonSyntax(value)

fun JsButton.Companion.syntax(value: JsElement): JsButton =
    JsButtonSyntax(value)