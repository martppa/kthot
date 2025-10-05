package net.asere.kthot.js.dsl.dom.type.data.geo.position

import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.number.value
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents the `GeolocationPositionError` object, providing details about a geolocation error.
 * Passed to error callbacks of `getCurrentPosition` and `watchPosition`.
 *
 * In JavaScript, this corresponds to the `PositionError` interface.
 */
interface JsGeolocationPositionError : JsObject {
    /**
     * Returns a numeric code indicating the type of error as a [JsNumber] object.
     * Possible values:
     * - `1` ([PERMISSION_DENIED]): The user denied permission to access location.
     * - `2` ([POSITION_UNAVAILABLE]): The position of the device could not be determined.
     * - `3` ([TIMEOUT]): The request timed out.
     *
     * In JavaScript, this corresponds to `error.code`.
     */
    val code: JsNumber get() = JsNumber.syntax(ChainOperation(this, "code"))

    /**
     * Returns a human-readable error message as a [JsString] object.
     *
     * In JavaScript, this corresponds to `error.message`.
     */
    val message: JsString get() = JsString.syntax(ChainOperation(this, "message"))

    companion object {
        /**
         * Error code constant: The user denied permission to access location.
         */
        val PERMISSION_DENIED: JsNumber get() = JsNumber.value(1)
        /**
         * Error code constant: The position of the device could not be determined.
         */
        val POSITION_UNAVAILABLE: JsNumber get() = JsNumber.value(2)
        /**
         * Error code constant: The request timed out.
         */
        val TIMEOUT: JsNumber get() = JsNumber.value(3)
    }
}