package net.asere.kthot.js.dsl.dom.type.window.history

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsHistory].
 */
class JsHistorySyntax internal constructor(value: String) :
    JsReferenceSyntax<JsHistory>(value), JsHistory {
    internal constructor(value: JsElement) : this("$value")
}

fun JsHistory.Companion.syntax(value: String): JsHistory =
    JsHistorySyntax(value)

fun JsHistory.Companion.syntax(value: JsElement): JsHistory =
    JsHistorySyntax(value)