package net.asere.kthot.js.dsl.dom.type.window.history

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

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