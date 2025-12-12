package net.asere.kthot.js.dsl.type.intl.format.date

import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents an instance of the JavaScript Intl.DateTimeFormat object, used for
 * language-sensitive date and time formatting. Extends the base JsObject.
 */
interface JsDateTimeFormat : JsObject {

    /**
     * Formats a date/time object according to the object's locale and formatting options.
     * Corresponds to `formatter.format(date)`.
     * @param date A [JsObject] representing the date, time, or timestamp to format (e.g., a Date object or a number).
     * @return A [JsString] representing the formatted date and time string.
     */
    fun format(date: JsObject): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("format", date)))

    /**
     * Returns an array of objects representing the date string in parts that can be used for custom formatting.
     * Corresponds to `formatter.formatToParts(date)`.
     * @param date A [JsObject] representing the date, time, or timestamp to format.
     * @return A [JsObject] representing the array of format parts.
     */
    fun formatToParts(date: JsObject): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("formatToParts", date)))

    /**
     * Returns a new object with properties reflecting the locale and date/time formatting options computed during initialization.
     * Corresponds to `formatter.resolvedOptions()`.
     * @return A [JsObject] containing the resolved options.
     */
    fun resolvedOptions(): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("resolvedOptions")))

    companion object {

        /**
         * Returns an array containing those of the provided locales that are supported by the implementation.
         * Corresponds to `Intl.DateTimeFormat.supportedLocalesOf(locales, options)`.
         * @param locales A [JsObject] representing the locale string or array of strings.
         * @param options A [JsObject] representing the date/time formatting options.
         * @return A [JsObject] representing the array of supported locale strings.
         */
        fun supportedLocalesOf(locales: JsObject, options: JsObject): JsObject =
            JsObject.syntax(ChainOperation(JsObject.syntax("DateTimeFormat"), InvocationOperation("supportedLocalesOf", locales, options)))
    }
}