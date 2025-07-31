package net.asere.kotlin.js.dsl.dom.type.geo.coordinates

import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.`object`.JsObject
import net.asere.kotlin.js.dsl.dom.type.geo.position.JsGeolocationPosition
import net.asere.kotlin.js.dsl.type.number.JsNumberSyntax

/**
 * Represents the `GeolocationCoordinates` object, containing the detailed geographical coordinates.
 * This object is part of the [JsGeolocationPosition] and provides specific location data.
 */
interface JsGeolocationCoordinates : JsObject {
    /**
     * Returns the latitude in degrees as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `coords.latitude`.
     */
    val latitude: JsNumber get() = JsNumberSyntax(ChainOperation(this, "latitude"))

    /**
     * Returns the longitude in degrees as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `coords.longitude`.
     */
    val longitude: JsNumber get() = JsNumberSyntax(ChainOperation(this, "longitude"))

    /**
     * Returns the altitude in meters above the WGS84 ellipsoid as a [JsNumber] object.
     * This value can be `null` if the altitude is not available.
     *
     * In JavaScript, this corresponds to `coords.altitude`.
     */
    val altitude: JsNumber get() = JsNumberSyntax(ChainOperation(this, "altitude"))

    /**
     * Returns the accuracy of the latitude and longitude coordinates in meters as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `coords.accuracy`.
     */
    val accuracy: JsNumber get() = JsNumberSyntax(ChainOperation(this, "accuracy"))

    /**
     * Returns the accuracy of the altitude in meters as a [JsNumber] object.
     * This value can be `null` if the altitude is not available.
     *
     * In JavaScript, this corresponds to `coords.altitudeAccuracy`.
     */
    val altitudeAccuracy: JsNumber get() = JsNumberSyntax(ChainOperation(this, "altitudeAccuracy"))

    /**
     * Returns the direction of the device in degrees clockwise from true north as a [JsNumber] object.
     * This value can be `null` if the heading is not available.
     *
     * In JavaScript, this corresponds to `coords.heading`.
     */
    val heading: JsNumber get() = JsNumberSyntax(ChainOperation(this, "heading"))

    /**
     * Returns the current ground speed of the device in meters per second as a [JsNumber] object.
     * This value can be `null` if the speed is not available.
     *
     * In JavaScript, this corresponds to `coords.speed`.
     */
    val speed: JsNumber get() = JsNumberSyntax(ChainOperation(this, "speed"))

    companion object
}