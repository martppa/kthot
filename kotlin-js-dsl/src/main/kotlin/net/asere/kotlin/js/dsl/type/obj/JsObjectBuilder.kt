package net.asere.kotlin.js.dsl.type.obj

import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Builder for creating JavaScript object literals.
 * This class provides a DSL-like way to construct a JavaScript object string
 * with key-value pairs.
 */
class JsObjectBuilder {
    private val properties = mutableListOf<String>()

    /**
     * Adds a property (key-value pair) to the JavaScript object being built.
     *
     * In JavaScript, this contributes to the object literal like:
     * ```javascript
     * {
     * key: value
     * }
     * ```
     * @param key The name of the property as a [String]. This will be used as the key in the JavaScript object.
     * @param value The [JsValue] to assign to the property. This can be any JavaScript primitive, object, or expression.
     */
    fun property(key: String, value: JsValue) {
        properties.add("$key: ${value.present()}") // Ensure value.present() is called for correct JS representation
    }

    /**
     * Builds the [JsObject] representing the JavaScript object literal with all added properties.
     *
     * @return A [JsObject] instance representing the complete JavaScript object literal string.
     */
    fun build(): JsObject = JsObject.value("{ \n${properties.joinToString(",\n")} \n}")
}