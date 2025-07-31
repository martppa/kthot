package net.asere.kotlin.js.dsl.dom.type.event.mouse

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.document.JsDocument
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsMouseEvent].
 */
class JsMouseEventSyntax internal constructor(value: String) : JsSyntax(value), JsMouseEvent {
    internal constructor(value: JsElement) : this("$value")
}

fun JsMouseEvent.Companion.syntax(value: String): JsMouseEventSyntax = JsMouseEventSyntax(value)
fun JsMouseEvent.Companion.syntax(value: JsElement): JsMouseEventSyntax = JsMouseEventSyntax(value)