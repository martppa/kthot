package net.asere.kthot.js.dsl.log

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.obj.JsObjectRef
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.bool.js
import net.asere.kthot.js.dsl.type.value.JsValue
import net.asere.kthot.js.dsl.type.array.value
import net.asere.kthot.js.dsl.type.string.js

/**
 * Represents the JavaScript `console` object, providing access to the browser's debugging console.
 * This object is typically used for logging messages, warnings, and errors.
 */
object Console : JsObjectRef("console") {
    /**
     * Outputs a message to the web console.
     *
     * In JavaScript, this corresponds to `console.log(element)`.
     * @param element The [JsElement] object to log.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun log(element: JsElement) = JsSyntax(ChainOperation(this, "log($element)"))

    /**
     * Outputs a message to the web console.
     * This is a convenience overload for [log] that accepts a Kotlin [String].
     *
     * @param text The [String] to log.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun log(text: String) = JsSyntax(ChainOperation(this, "log(${text.js})"))

    /**
     * Outputs a warning message to the web console.
     *
     * In JavaScript, this corresponds to `console.warn(message)`.
     * @param message The [JsValue] object to log as a warning.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun warn(message: JsValue) = JsSyntax(ChainOperation(this, "warn($message)"))

    /**
     * Outputs a warning message to the web console.
     * This is a convenience overload for [warn] that accepts a Kotlin [String].
     *
     * @param text The [String] to log as a warning.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun warn(text: String) = warn(text.js)

    /**
     * Outputs an error message to the web console.
     *
     * In JavaScript, this corresponds to `console.error(message)`.
     * @param message The [JsValue] object to log as an error.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun error(message: JsValue) = JsSyntax(ChainOperation(this, "error($message)"))

    /**
     * Outputs an error message to the web console.
     * This is a convenience overload for [error] that accepts a Kotlin [String].
     *
     * @param text The [String] to log as an error.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun error(text: String) = error(text.js)

    /**
     * Outputs an informational message to the web console.
     *
     * In JavaScript, this corresponds to `console.info(message)`.
     * @param message The [JsValue] object to log as info.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun info(message: JsValue) = JsSyntax(ChainOperation(this, "info($message)"))

    /**
     * Outputs an informational message to the web console.
     * This is a convenience overload for [info] that accepts a Kotlin [String].
     *
     * @param text The [String] to log as info.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun info(text: String) = info(text.js)

    /**
     * Outputs a debug message to the web console.
     *
     * In JavaScript, this corresponds to `console.debug(message)`.
     * @param message The [JsValue] object to log as debug.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun debug(message: JsValue) = JsSyntax(ChainOperation(this, "debug($message)"))

    /**
     * Outputs a debug message to the web console.
     * This is a convenience overload for [debug] that accepts a Kotlin [String].
     *
     * @param text The [String] to log as debug.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun debug(text: String) = debug(text.js)

    /**
     * Clears the console.
     *
     * In JavaScript, this corresponds to `console.clear()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun clear() = JsSyntax(ChainOperation(this, "clear()"))

    /**
     * Starts a new timer under the specified name. Call `console.timeEnd()` with the same name
     * to stop the timer and log the elapsed time.
     *
     * In JavaScript, this corresponds to `console.time(label)`.
     * @param label The label for the timer as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun time(label: JsString) = JsSyntax(ChainOperation(this, "time($label)"))
    fun time(label: String) = time(label.js)

    /**
     * Stops a timer that was previously started with `console.time()` and logs the elapsed time.
     *
     * In JavaScript, this corresponds to `console.timeEnd(label)`.
     * @param label The label of the timer to stop as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun timeEnd(label: JsString) = JsSyntax(ChainOperation(this, "timeEnd($label)"))
    fun timeEnd(label: String) = timeEnd(label.js)

    /**
     * Logs a message to the console if the first argument is `false`.
     *
     * In JavaScript, this corresponds to `console.assert(condition, message)`.
     * @param condition The condition to check as a [JsBoolean] object.
     * @param message The message to log if the condition is false as a [JsValue] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun assert(condition: JsBoolean, message: JsValue) =
        JsSyntax(ChainOperation(this, "assert($condition, $message)"))

    fun assert(condition: Boolean, message: String) = assert(condition.js, message.js)

    /**
     * Creates a new inline group in the console. This indents all following console output
     * by an additional level, until `console.groupEnd()` is called.
     *
     * In JavaScript, this corresponds to `console.group(label)`.
     * @param label An optional [JsString] object to label the group.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun group(label: JsString? = null) =
        JsSyntax(ChainOperation(this, "group(${label ?: ""})"))

    fun group(label: String) = group(label.js)

    /**
     * Closes the most recently opened inline group in the console.
     *
     * In JavaScript, this corresponds to `console.groupEnd()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun groupEnd() = JsSyntax(ChainOperation(this, InvocationOperation("groupEnd")))

    /**
     * Creates a new inline group in the console that is initially collapsed.
     *
     * In JavaScript, this corresponds to `console.groupCollapsed(label)`.
     * @param label An optional [JsString] object to label the group.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun groupCollapsed(label: JsString? = null) =
        JsSyntax(ChainOperation(this, "groupCollapsed(${label ?: ""})"))

    fun groupCollapsed(label: String) = groupCollapsed(label.js)

    /**
     * Displays tabular data in the console.
     *
     * In JavaScript, this corresponds to `console.table(data, properties)`.
     * @param data The data to display as a table as a [JsValue] object.
     * @param properties An optional [JsArray] of [JsString] objects specifying which properties of the objects to display.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun table(data: JsValue, properties: JsArray<JsString>? = null) =
        JsSyntax(
            ChainOperation(
                leftHand = this,
            rightHand = "table($data${properties?.let { ", $it" } ?: ""})"))

    fun table(data: JsValue, vararg properties: String) =
        table(data, JsArray.value(*properties.map { it.js }.toTypedArray()))
}