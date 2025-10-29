package net.asere.kthot.js.dsl.dom.type.data.geo.position

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.dom.type.data.event.keyboard.JsKeyboardEvent
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsGeolocationPositionOptions].
 */
class JsGeolocationPositionOptionsSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsKeyboardEvent>(value), JsGeolocationPositionOptions {
    internal constructor(value: JsElement) : this("$value")
}

fun JsGeolocationPositionOptions.Companion.syntax(value: String): JsGeolocationPositionOptions =
    JsGeolocationPositionOptionsSyntax(value)

fun JsGeolocationPositionOptions.Companion.syntax(
    value: JsElement,
    
): JsGeolocationPositionOptions = JsGeolocationPositionOptionsSyntax(value)