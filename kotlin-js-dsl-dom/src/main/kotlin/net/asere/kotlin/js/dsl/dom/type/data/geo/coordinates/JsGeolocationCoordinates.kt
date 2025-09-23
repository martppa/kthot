package net.asere.kotlin.js.dsl.dom.type.data.geo.coordinates

import net.asere.kotlin.js.dsl.dom.type.data.geo.position.JsGeolocationPosition
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.syntax
import net.asere.kotlin.js.dsl.type.obj.JsObject

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
    val latitude: JsNumber get() = JsNumber.syntax(ChainOperation(this, "latitude"))

    /**
     * Returns the longitude in degrees as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `coords.longitude`.
     */
    val longitude: JsNumber get() = JsNumber.syntax(ChainOperation(this, "longitude"))

    /**
     * Returns the altitude in meters above the WGS84 ellipsoid as a [JsNumber] object.
     * This value can be `null` if the altitude is not available.
     *
     * In JavaScript, this corresponds to `coords.altitude`.
     */
    val altitude: JsNumber get() = JsNumber.syntax(ChainOperation(this, "altitude"))

    /**
     * Returns the accuracy of the latitude and longitude coordinates in meters as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `coords.accuracy`.
     */
    val accuracy: JsNumber get() = JsNumber.syntax(ChainOperation(this, "accuracy"))

    /**
     * Returns the accuracy of the altitude in meters as a [JsNumber] object.
     * This value can be `null` if the altitude is not available.
     *
     * In JavaScript, this corresponds to `coords.altitudeAccuracy`.
     */
    val altitudeAccuracy: JsNumber get() = JsNumber.syntax(ChainOperation(this, "altitudeAccuracy"))

    /**
     * Returns the direction of the device in degrees clockwise from true north as a [JsNumber] object.
     * This value can be `null` if the heading is not available.
     *
     * In JavaScript, this corresponds to `coords.heading`.
     */
    val heading: JsNumber get() = JsNumber.syntax(ChainOperation(this, "heading"))

    /**
     * Returns the current ground speed of the device in meters per second as a [JsNumber] object.
     * This value can be `null` if the speed is not available.
     *
     * In JavaScript, this corresponds to `coords.speed`.
     */
    val speed: JsNumber get() = JsNumber.syntax(ChainOperation(this, "speed"))

    companion object
}