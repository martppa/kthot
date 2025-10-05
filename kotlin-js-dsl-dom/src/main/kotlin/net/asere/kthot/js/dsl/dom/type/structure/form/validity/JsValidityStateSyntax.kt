package net.asere.kthot.js.dsl.dom.type.structure.form.validity

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsValidityState].
 */
class JsValidityStateSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsValidityState>(value, isNullable), JsValidityState {
    internal constructor (value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsValidityState.Companion.syntax(value: String, isNullable: Boolean = false): JsValidityState =
    JsValidityStateSyntax(value, isNullable)

fun JsValidityState.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsValidityState =
    JsValidityStateSyntax(value, isNullable)