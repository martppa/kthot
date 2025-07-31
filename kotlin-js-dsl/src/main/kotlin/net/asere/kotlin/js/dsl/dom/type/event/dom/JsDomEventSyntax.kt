package net.asere.kotlin.js.dsl.dom.type.event.dom

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.document.JsDocument
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsDomEvent].
 */
class JsDomEventSyntax internal constructor(value: String) : JsSyntax(value), JsDomEvent {
    internal constructor(value: JsElement) : this("$value")
}

fun JsDomEvent.Companion.syntax(value: String): JsDomEventSyntax = JsDomEventSyntax(value)
fun JsDomEvent.Companion.syntax(value: JsElement): JsDomEventSyntax = JsDomEventSyntax(value)