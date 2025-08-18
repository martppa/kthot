package net.asere.kotlin.js.dsl.dom.type.history

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.event.mouse.JsMouseEvent
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsHistory].
 */
class JsHistorySyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsHistory>(value, isNullable), JsHistory {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsHistory.Companion.syntax(value: String, isNullable: Boolean = false): JsHistory =
    JsHistorySyntax(value, isNullable)

fun JsHistory.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsHistory =
    JsHistorySyntax(value, isNullable)