package net.asere.kotlin.js.dsl.dom.type.location

import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.JsString
import net.asere.kotlin.js.dsl.types.value.value

interface JsGeolocationPositionError : JsObject {
    /**
     * Returns a numeric code indicating the type of error as a [JsNumber] object.
     * Possible values:
     * - `1` ([PERMISSION_DENIED]): The user denied permission to access location.
     * - `2` ([POSITION_UNAVAILABLE]): The position of the device could not be determined.
     * - `3` ([TIMEOUT]): The request timed out.
     */
    val code: JsNumber get() = JsNumberSyntax("${this}.code")

    /**
     * Returns a human-readable error message as a [JsString] object.
     */
    val message: JsString get() = JsStringSyntax("${this}.message")

    companion object {
        val PERMISSION_DENIED: JsNumber get() = JsNumber.value(1)
        val POSITION_UNAVAILABLE: JsNumber get() = JsNumber.value(2)
        val TIMEOUT: JsNumber get() = JsNumber.value(3)
    }
}