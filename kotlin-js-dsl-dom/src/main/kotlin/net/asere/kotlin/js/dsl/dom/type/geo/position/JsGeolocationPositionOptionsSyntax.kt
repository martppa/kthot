package net.asere.kotlin.js.dsl.dom.type.geo.position

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.dom.type.event.keyboard.JsKeyboardEvent
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax

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