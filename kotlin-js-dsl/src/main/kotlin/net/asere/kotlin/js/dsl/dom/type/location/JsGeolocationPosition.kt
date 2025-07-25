package net.asere.kotlin.js.dsl.dom.type.location

import net.asere.kotlin.js.dsl.dom.reference.location.ref
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.JsObject

/**
 * Represents the `GeolocationPosition` object, containing the device's geographical position.
 * Passed to success callbacks of `getCurrentPosition` and `watchPosition`.
 */
interface JsGeolocationPosition : JsObject {
    val coords: JsGeolocationCoordinates get() = JsGeolocationCoordinates.ref("${this}.coords")
    val timestamp: JsNumber get() = JsNumberSyntax("${this}.timestamp")

    companion object
}

interface JsPositionOptions : JsObject {
    companion object
}

class JsPositionOptionsSyntax(value: String) : JsSyntax(value), JsPositionOptions

/**
 * Builder for creating JavaScript `PositionOptions` objects, used to configure geolocation requests.
 * This class helps construct the options object as a [JsSyntax] string.
 */
class JsPositionOptionsBuilder {
    /**
     * Indicates whether to use a more accurate position, at the cost of slower response times or increased power consumption.
     * Defaults to `false`.
     */
    var enableHighAccuracy: Boolean? = null

    /**
     * The maximum length of time (in milliseconds) the device is allowed to take to return a position.
     * Defaults to `Infinity`.
     */
    var timeout: Int? = null

    /**
     * The maximum age (in milliseconds) of a possible cached position that is acceptable to return.
     * Defaults to `0`.
     */
    var maximumAge: Int? = null

    /**
     * Builds the [JsPositionOptions] representation of the `PositionOptions` object.
     */
    fun build(): JsPositionOptions {
        val properties = mutableListOf<String>()
        enableHighAccuracy?.let { properties.add("enableHighAccuracy: $it") }
        timeout?.let { properties.add("timeout: $it") }
        maximumAge?.let { properties.add("maximumAge: $it") }
        return JsPositionOptionsSyntax("{ ${properties.joinToString(", ")} }")
    }
}

/**
 * Helper function to create a [JsPositionOptions] object representing `PositionOptions` using a DSL-like builder.
 * @param block A lambda with receiver [JsPositionOptionsBuilder] to configure the options.
 * @return A [JsPositionOptions] object representing the JavaScript `PositionOptions` literal.
 */
fun JsPositionOptions.Companion.build(block: JsPositionOptionsBuilder.() -> Unit): JsPositionOptions =
    JsPositionOptionsBuilder().apply(block).build()
