package net.asere.kotlin.js.dsl.dom.type.structure.form.validity

import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.JsElement

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