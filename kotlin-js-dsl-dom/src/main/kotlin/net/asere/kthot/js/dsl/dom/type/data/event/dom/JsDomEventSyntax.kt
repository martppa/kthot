package net.asere.kthot.js.dsl.dom.type.data.event.dom

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsDomEvent].
 */
class JsDomEventSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsDomEvent>(value), JsDomEvent {
    internal constructor(value: JsElement) : this("$value")
}

fun JsDomEvent.Companion.syntax(value: String): JsDomEvent =
    JsDomEventSyntax(value)

fun JsDomEvent.Companion.syntax(value: JsElement): JsDomEvent =
    JsDomEventSyntax(value)