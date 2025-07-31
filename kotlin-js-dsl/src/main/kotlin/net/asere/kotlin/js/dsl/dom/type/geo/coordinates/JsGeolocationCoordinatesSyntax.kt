package net.asere.kotlin.js.dsl.dom.type.geo.coordinates

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.geo.position.JsGeolocationPositionOptions
import net.asere.kotlin.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsGeolocationPositionOptions].
 */
class JsGeolocationCoordinatesSyntax internal constructor(value: String) : JsSyntax(value), JsGeolocationCoordinates {
    internal constructor(value: JsElement) : this("$value")
}

fun JsGeolocationCoordinates.Companion.syntax(value: String): JsGeolocationCoordinatesSyntax =
    JsGeolocationCoordinatesSyntax(value)
fun JsGeolocationCoordinates.Companion.syntax(value: JsElement): JsGeolocationCoordinatesSyntax =
    JsGeolocationCoordinatesSyntax(value)