package net.asere.kotlin.js.dsl.dom.type.data.event.mouse

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsMouseEvent].
 */
class JsMouseEventSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsMouseEvent>(value, isNullable), JsMouseEvent {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsMouseEvent.Companion.syntax(value: String, isNullable: Boolean = false): JsMouseEvent =
    JsMouseEventSyntax(value, isNullable)

fun JsMouseEvent.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsMouseEvent =
    JsMouseEventSyntax(value, isNullable)