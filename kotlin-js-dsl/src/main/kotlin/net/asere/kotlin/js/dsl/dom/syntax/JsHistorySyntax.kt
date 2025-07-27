package net.asere.kotlin.js.dsl.dom.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.JsHistory
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsHistory].
 */
class JsHistorySyntax(value: String) : JsSyntax(value), JsHistory {
    constructor(value: JsElement) : this("$value")
}