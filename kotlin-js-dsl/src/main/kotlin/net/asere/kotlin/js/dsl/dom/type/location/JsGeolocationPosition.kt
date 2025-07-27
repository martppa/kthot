package net.asere.kotlin.js.dsl.dom.type.location

import net.asere.kotlin.js.dsl.dom.syntax.location.JsGeolocationCoordinatesSyntax
import net.asere.kotlin.js.dsl.dom.syntax.location.JsPositionOptionsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.helper.JsObjectBuilder
import net.asere.kotlin.js.dsl.types.type.js

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
    val coords: JsGeolocationCoordinates get() = JsGeolocationCoordinatesSyntax(ChainOperation(this, "coords"))

    /**
     * Returns the time (in milliseconds since the epoch) at which the location was retrieved
     * as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `position.timestamp`.
     */
    val timestamp: JsNumber get() = JsNumberSyntax(ChainOperation(this, "timestamp"))

    companion object
}
