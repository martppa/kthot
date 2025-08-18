package net.asere.kotlin.js.dsl.dom.type.event.dom

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.document.JsDocument
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax

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