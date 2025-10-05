package net.asere.kthot.js.dsl.dom.type.data.event.dom

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsDomEvent].
 */
class JsDomEventSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsDomEvent>(value, isNullable), JsDomEvent {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsDomEvent.Companion.syntax(value: String, isNullable: Boolean = false): JsDomEvent =
    JsDomEventSyntax(value, isNullable)

fun JsDomEvent.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsDomEvent =
    JsDomEventSyntax(value, isNullable)