package net.asere.kotlin.js.dsl.dom.type.location

import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.JsObject

/**
 * Represents the `GeolocationCoordinates` object, containing the detailed geographical coordinates.
 */
interface JsGeolocationCoordinates : JsObject {
    val latitude: JsNumber get() = JsNumberSyntax("${this}.latitude")
    val longitude: JsNumber get() = JsNumberSyntax("${this}.longitude")
    val altitude: JsNumber get() = JsNumberSyntax("${this}.altitude")
    val accuracy: JsNumber get() = JsNumberSyntax("${this}.accuracy")
    val altitudeAccuracy: JsNumber get() = JsNumberSyntax("${this}.altitudeAccuracy")
    val heading: JsNumber get() = JsNumberSyntax("${this}.heading")
    val speed: JsNumber get() = JsNumberSyntax("${this}.speed")

    companion object
}
