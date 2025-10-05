package net.asere.kthot.js.dsl.dom.type.data.geo.position

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.dom.type.data.event.keyboard.JsKeyboardEvent
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsGeolocationPositionOptions].
 */
class JsGeolocationPositionOptionsSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsKeyboardEvent>(value, isNullable), JsGeolocationPositionOptions {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsGeolocationPositionOptions.Companion.syntax(value: String, isNullable: Boolean = false): JsGeolocationPositionOptions =
    JsGeolocationPositionOptionsSyntax(value, isNullable)

fun JsGeolocationPositionOptions.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false
): JsGeolocationPositionOptions = JsGeolocationPositionOptionsSyntax(value, isNullable)