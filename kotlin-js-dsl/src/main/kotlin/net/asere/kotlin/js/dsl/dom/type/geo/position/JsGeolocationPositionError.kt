package net.asere.kotlin.js.dsl.dom.type.geo.position

import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.type.string.JsStringSyntax
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.`object`.JsObject
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.array.value

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
    val code: JsNumber get() = JsNumberSyntax(ChainOperation(this, "code"))

    /**
     * Returns a human-readable error message as a [JsString] object.
     *
     * In JavaScript, this corresponds to `error.message`.
     */
    val message: JsString get() = JsStringSyntax(ChainOperation(this, "message"))

    companion object {
        /**
         * Error code constant: The user denied permission to access location.
         */
        val PERMISSION_DENIED: JsNumber get() = value(1)
        /**
         * Error code constant: The position of the device could not be determined.
         */
        val POSITION_UNAVAILABLE: JsNumber get() = value(2)
        /**
         * Error code constant: The request timed out.
         */
        val TIMEOUT: JsNumber get() = value(3)
    }
}