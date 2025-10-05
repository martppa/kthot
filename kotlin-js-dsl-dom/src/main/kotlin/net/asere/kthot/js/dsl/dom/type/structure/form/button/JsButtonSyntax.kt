package net.asere.kthot.js.dsl.dom.type.structure.form.button


import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsButton].
 */
class JsButtonSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsButton>(value, isNullable), JsButton {
    internal constructor (value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsButton.Companion.syntax(value: String, isNullable: Boolean = false): JsButton =
    JsButtonSyntax(value, isNullable)

fun JsButton.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsButton =
    JsButtonSyntax(value, isNullable)