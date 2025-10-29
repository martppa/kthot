package net.asere.kthot.js.dsl.dom.type.data.geo.coordinates

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.dom.type.data.geo.position.JsGeolocationPositionOptions
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

/**
 * A [JsSyntax] implementation specifically for [JsGeolocationPositionOptions].
 */
class JsGeolocationCoordinatesSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsGeolocationCoordinates>(value), JsGeolocationCoordinates {
    internal constructor(value: JsElement) : this("$value")
}

fun JsGeolocationCoordinates.Companion.syntax(value: String): JsGeolocationCoordinates =
    JsGeolocationCoordinatesSyntax(value)

fun JsGeolocationCoordinates.Companion.syntax(value: JsElement): JsGeolocationCoordinates =
    JsGeolocationCoordinatesSyntax(value)