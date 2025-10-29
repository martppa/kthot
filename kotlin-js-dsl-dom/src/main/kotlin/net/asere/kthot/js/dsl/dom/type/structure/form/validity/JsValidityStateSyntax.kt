package net.asere.kthot.js.dsl.dom.type.structure.form.validity

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsValidityState].
 */
class JsValidityStateSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsValidityState>(value), JsValidityState {
    internal constructor (value: JsElement) : this("$value")
}

fun JsValidityState.Companion.syntax(value: String): JsValidityState =
    JsValidityStateSyntax(value)

fun JsValidityState.Companion.syntax(value: JsElement): JsValidityState =
    JsValidityStateSyntax(value)