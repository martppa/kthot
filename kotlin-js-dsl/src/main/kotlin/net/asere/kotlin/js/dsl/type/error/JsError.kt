package net.asere.kotlin.js.dsl.type.error

import net.asere.kotlin.js.dsl.syntax.instantiation.Instantiable
import net.asere.kotlin.js.dsl.type.bool.syntax
import net.asere.kotlin.js.dsl.type.string.JsStringSyntax
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.syntax

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
    val errorName: JsString get() = JsString.syntax("${this}.name")

    /**
     * Returns a human-readable description of the error as a [JsString] object.
     *
     * In JavaScript, this corresponds to `error.message`.
     */
    val message: JsString get() = JsString.syntax("${this}.message")

    /**
     * Returns a string representing the stack trace of the error as a [JsString] object.
     * This property is non-standard but widely supported in modern browsers and Node.js.
     *
     * In JavaScript, this corresponds to `error.stack`.
     */
    val stack: JsString get() = JsString.syntax("${this}.stack")

    companion object
}