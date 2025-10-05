package net.asere.kthot.js.dsl.dom.type.data.geo.coordinates

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.dom.type.data.geo.position.JsGeolocationPositionOptions
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax

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