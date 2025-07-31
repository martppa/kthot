package net.asere.kotlin.js.dsl.dom.type.event.keyboard

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsKeyboardEvent].
 */
class JsKeyboardEventSyntax internal constructor(value: String) : JsSyntax(value), JsKeyboardEvent {
    internal constructor(value: JsElement) : this("$value")
}

fun JsKeyboardEvent.Companion.syntax(value: String): JsKeyboardEventSyntax = JsKeyboardEventSyntax(value)
fun JsKeyboardEvent.Companion.syntax(value: JsElement): JsKeyboardEventSyntax = JsKeyboardEventSyntax(value)