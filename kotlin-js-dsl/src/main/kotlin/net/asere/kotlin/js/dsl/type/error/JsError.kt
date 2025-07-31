package net.asere.kotlin.js.dsl.type.error

import net.asere.kotlin.js.dsl.syntax.instantiation.Instantiable
import net.asere.kotlin.js.dsl.type.string.JsStringSyntax
import net.asere.kotlin.js.dsl.type.`object`.JsObject
import net.asere.kotlin.js.dsl.type.string.JsString

/**
 * Represents the JavaScript `Error` object.
 * This object is typically thrown when runtime errors occur.
 * It provides information about the error, such as its name, message, and stack trace.
 */
interface JsError : JsObject, Instantiable {

    /**
     * Returns the name of the error type (e.g., "Error", "TypeError", "ReferenceError")
     * as a [JsString] object.
     *
     * In JavaScript, this corresponds to `error.name`.
     */
    val errorName: JsString get() = JsStringSyntax("${this}.name")

    /**
     * Returns a human-readable description of the error as a [JsString] object.
     *
     * In JavaScript, this corresponds to `error.message`.
     */
    val message: JsString get() = JsStringSyntax("${this}.message")

    /**
     * Returns a string representing the stack trace of the error as a [JsString] object.
     * This property is non-standard but widely supported in modern browsers and Node.js.
     *
     * In JavaScript, this corresponds to `error.stack`.
     */
    val stack: JsString get() = JsStringSyntax("${this}.stack")

    companion object
}