package net.asere.kthot.js.dsl.dom.type.data.event.keyboard

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsKeyboardEvent].
 */
class JsKeyboardEventSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsKeyboardEvent>(value, isNullable), JsKeyboardEvent {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsKeyboardEvent.Companion.syntax(value: String, isNullable: Boolean = false): JsKeyboardEventSyntax =
    JsKeyboardEventSyntax(value, isNullable)

fun JsKeyboardEvent.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsKeyboardEventSyntax =
    JsKeyboardEventSyntax(value, isNullable)