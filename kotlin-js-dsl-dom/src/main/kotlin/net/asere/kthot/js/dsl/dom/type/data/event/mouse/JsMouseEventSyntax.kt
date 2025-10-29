package net.asere.kthot.js.dsl.dom.type.data.event.mouse

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsMouseEvent].
 */
class JsMouseEventSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsMouseEvent>(value), JsMouseEvent {
    internal constructor(value: JsElement) : this("$value")
}

fun JsMouseEvent.Companion.syntax(value: String): JsMouseEvent =
    JsMouseEventSyntax(value)

fun JsMouseEvent.Companion.syntax(value: JsElement): JsMouseEvent =
    JsMouseEventSyntax(value)