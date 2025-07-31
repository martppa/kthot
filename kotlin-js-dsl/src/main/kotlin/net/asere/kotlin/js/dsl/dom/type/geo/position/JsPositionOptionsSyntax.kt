package net.asere.kotlin.js.dsl.dom.type.geo.position

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsGeolocationPositionOptions].
 */
class JsPositionOptionsSyntax internal constructor(value: String) : JsSyntax(value), JsGeolocationPositionOptions {
    internal constructor(value: JsElement) : this("$value")
}

fun JsGeolocationPosition.Companion.syntax(value: String): JsPositionOptionsSyntax = JsPositionOptionsSyntax(value)
fun JsGeolocationPosition.Companion.syntax(value: JsElement): JsPositionOptionsSyntax = JsPositionOptionsSyntax(value)