package net.asere.kthot.js.dsl.type.intl.format.time

import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents an instance of the JavaScript Intl.RelativeTimeFormat object.
 * Used for formatting relative time spans. Extends the base JsObject.
 */
interface JsRelativeTimeFormat : JsObject {
    /**
     * Formats a relative time span.
     * Corresponds to `formatter.format(value, unit)`.
     * @param value A [JsNumber] representing the numeric value of the time span (e.g., 5 or -2).
     * @param unit A [JsString] representing the unit of time (e.g., "second", "day", "year").
     * @return A [JsString] representing the formatted relative time string (e.g., "5 minutes ago").
     */
    fun format(value: JsNumber, unit: JsString): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("format", value, unit)))

    /**
     * Formats a relative time span into an array of objects representing the parts of the formatted string.
     * Corresponds to `formatter.formatToParts(value, unit)`.
     * @param value A [JsNumber] representing the numeric value of the time span.
     * @param unit A [JsString] representing the unit of time.
     * @return A [JsObject] representing the array of format parts.
     */
    fun formatToParts(value: JsNumber, unit: JsString): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("formatToParts", value, unit)))

    /**
     * Returns a new object with properties reflecting the locale and relative time formatting options.
     * Corresponds to `formatter.resolvedOptions()`.
     * @return A [JsObject] containing the resolved options.
     */
    fun resolvedOptions(): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("resolvedOptions")))

    companion object {
        /**
         * Returns an array containing those of the provided locales that are supported by the implementation.
         * Corresponds to `Intl.RelativeTimeFormat.supportedLocalesOf(locales, options)`.
         * @param locales A [JsObject] representing the locale string or array of strings.
         * @param options A [JsObject] representing the relative time formatting options.
         * @return A [JsObject] representing the array of supported locale strings.
         */
        fun supportedLocalesOf(locales: JsObject, options: JsObject): JsObject =
            JsObject.syntax(ChainOperation(JsObject.syntax("Intl.RelativeTimeFormat"), InvocationOperation("supportedLocalesOf", locales, options)))
    }
}