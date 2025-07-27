package net.asere.kotlin.js.dsl.dom.syntax.location

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.location.JsPositionOptions
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsPositionOptions].
 */
class JsPositionOptionsSyntax(value: String) : JsSyntax(value), JsPositionOptions {
    constructor(value: JsElement) : this("$value")
}