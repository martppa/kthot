package net.asere.kthot.js.dsl.dom.type.data.event.keyboard

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsKeyboardEvent].
 */
class JsKeyboardEventSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsKeyboardEvent>(value), JsKeyboardEvent {
    internal constructor(value: JsElement) : this("$value")
}

fun JsKeyboardEvent.Companion.syntax(value: String): JsKeyboardEventSyntax =
    JsKeyboardEventSyntax(value)

fun JsKeyboardEvent.Companion.syntax(value: JsElement): JsKeyboardEventSyntax =
    JsKeyboardEventSyntax(value)