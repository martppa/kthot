package net.asere.kotlin.js.dsl.dom.type.geo.coordinates

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.dom.type.geo.position.JsGeolocationPositionOptions
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsGeolocationPositionOptions].
 */
class JsGeolocationCoordinatesSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsGeolocationCoordinates>(value, isNullable), JsGeolocationCoordinates {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsGeolocationCoordinates.Companion.syntax(value: String, isNullable: Boolean = false): JsGeolocationCoordinates =
    JsGeolocationCoordinatesSyntax(value, isNullable)

fun JsGeolocationCoordinates.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsGeolocationCoordinates =
    JsGeolocationCoordinatesSyntax(value, isNullable)