package net.asere.kotlin.js.dsl.dom.type.data.geo.position

import net.asere.kotlin.js.dsl.dom.type.data.geo.coordinates.JsGeolocationCoordinates
import net.asere.kotlin.js.dsl.dom.type.data.geo.coordinates.syntax
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.syntax
import net.asere.kotlin.js.dsl.type.obj.JsObject

/**
 * Represents the `GeolocationPosition` object, containing the device's geographical position.
 * Passed to success callbacks of `getCurrentPosition` and `watchPosition`.
 */
interface JsGeolocationPosition : JsObject {
    /**
     * Returns a [JsGeolocationCoordinates] object containing the geographical coordinates and accuracy.
     *
     * In JavaScript, this corresponds to `position.coords`.
     */
    val coords: JsGeolocationCoordinates get() = JsGeolocationCoordinates.syntax(ChainOperation(this, "coords"))

    /**
     * Returns the time (in milliseconds since the epoch) at which the location was retrieved
     * as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `position.timestamp`.
     */
    val timestamp: JsNumber get() = JsNumber.syntax(ChainOperation(this, "timestamp"))

    companion object
}
