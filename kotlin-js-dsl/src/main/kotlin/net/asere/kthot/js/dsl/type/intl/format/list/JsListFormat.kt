package net.asere.kthot.js.dsl.type.intl.format.list

import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents an instance of the JavaScript Intl.ListFormat object.
 * Used for language-sensitive list formatting. Extends the base JsObject.
 */
interface JsListFormat : JsObject {
    /**
     * Formats an array of strings into a language-sensitive list string.
     * Corresponds to `formatter.format(items)`.
     * @param items A [JsObject] representing the array of strings (or other types convertible to strings) to join.
     * @return A [JsString] representing the formatted list (e.g., "red, green, and blue").
     */
    fun format(items: JsObject): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("format", items)))

    /**
     * Returns a new object with properties reflecting the locale and list formatting options computed during initialization.
     * Corresponds to `formatter.resolvedOptions()`.
     * @return A [JsObject] containing the resolved options.
     */
    fun resolvedOptions(): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("resolvedOptions")))

    companion object {

        /**
         * Returns an array containing those of the provided locales that are supported by the implementation.
         * Corresponds to `Intl.ListFormat.supportedLocalesOf(locales, options)`.
         * @param locales A [JsObject] representing the locale string or array of strings.
         * @param options A [JsObject] representing the list formatting options.
         * @return A [JsObject] representing the array of supported locale strings.
         */
        fun supportedLocalesOf(locales: JsObject, options: JsObject): JsObject =
            JsObject.syntax(ChainOperation(JsObject.syntax("Intl.ListFormat"), InvocationOperation("supportedLocalesOf", locales, options)))
    }
}