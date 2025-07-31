package net.asere.kotlin.js.dsl.dom.type.geo.position

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.`object`.JsObjectBuilder
import net.asere.kotlin.js.dsl.type.bool.js
import net.asere.kotlin.js.dsl.type.number.js

/**
 * Builder for creating JavaScript `PositionOptions` objects, used to configure geolocation requests.
 * This class helps construct the options object as a [JsSyntax] string.
 */
class JsGeolocationPositionOptionsBuilder {
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
     * Builds the [JsGeolocationPositionOptions] representation of the `PositionOptions` object.
     */
    fun build(): JsGeolocationPositionOptions {
        val objectBuilder = JsObjectBuilder()
        enableHighAccuracy?.let { objectBuilder.property("enableHighAccuracy", it.js) }
        timeout?.let { objectBuilder.property("timeout", it.js) }
        maximumAge?.let { objectBuilder.property("maximumAge", it.js) }
        return JsPositionOptionsSyntax("${objectBuilder.build()}")
    }
}

/**
 * Helper function to create a [JsGeolocationPositionOptions] object representing `PositionOptions` using a DSL-like builder.
 * @param block A lambda with receiver [JsGeolocationPositionOptionsBuilder] to configure the options.
 * @return A [JsGeolocationPositionOptions] object representing the JavaScript `PositionOptions` literal.
 */
fun JsGeolocationPositionOptions.Companion.build(block: JsGeolocationPositionOptionsBuilder.() -> Unit): JsGeolocationPositionOptions =
    JsGeolocationPositionOptionsBuilder().apply(block).build()