package net.asere.kthot.js.dsl.type.intl.names

import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents an instance of the JavaScript Intl.DisplayNames object.
 * Used for translating codes into localized names. Extends the base JsObject.
 */
interface JsDisplayNames : JsObject {
    /**
     * Returns the localized display name for a code (e.g., language code, region code).
     * Corresponds to `displayNames.of(code)`.
     * @param code A [JsString] representing the code to translate (e.g., "fr" for French).
     * @return A [JsString] representing the localized name.
     */
    fun of(code: JsString): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("of", code)))

    /**
     * Returns a new object with properties reflecting the locale and display names options computed during initialization.
     * Corresponds to `displayNames.resolvedOptions()`.
     * @return A [JsObject] containing the resolved options.
     */
    fun resolvedOptions(): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("resolvedOptions")))

    companion object {

        /**
         * Returns an array containing those of the provided locales that are supported by the implementation.
         * Corresponds to `Intl.DisplayNames.supportedLocalesOf(locales, options)`.
         * @param locales A [JsObject] representing the locale string or array of strings.
         * @param options A [JsObject] representing the display names options.
         * @return A [JsObject] representing the array of supported locale strings.
         */
        fun supportedLocalesOf(locales: JsObject, options: JsObject): JsObject =
            JsObject.syntax(ChainOperation(JsObject.syntax("Intl.DisplayNames"), InvocationOperation("supportedLocalesOf", locales, options)))
    }
}