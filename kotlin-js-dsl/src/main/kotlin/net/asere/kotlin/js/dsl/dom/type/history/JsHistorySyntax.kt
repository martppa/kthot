package net.asere.kotlin.js.dsl.dom.type.history

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsHistory].
 */
class JsHistorySyntax internal constructor(value: String) : JsSyntax(value), JsHistory {
    internal constructor(value: JsElement) : this("$value")
}

fun JsHistory.Companion.syntax(value: String): JsHistorySyntax = JsHistorySyntax(value)
fun JsHistory.Companion.syntax(value: JsElement): JsHistorySyntax = JsHistorySyntax(value)