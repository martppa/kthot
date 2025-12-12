package net.asere.kthot.js.dsl.type.intl.plural

import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents an instance of the JavaScript Intl.PluralRules object, used for
 * determining the plural form of a number in a given locale. Extends the base JsObject.
 */
interface JsPluralRules : JsObject {
    /**
     * Returns the appropriate plural category for a number in the locale.
     * Categories include "zero", "one", "two", "few", "many", and "other".
     *
     * Corresponds to `rules.select(number)`.
     * @param number A [JsNumber] representing the number to check.
     * @return A [JsString] representing the plural category.
     */
    fun select(number: JsNumber): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("select", number)))

    /**
     * Returns a new object with properties reflecting the locale and plural rules options computed during initialization.
     * Corresponds to `rules.resolvedOptions()`.
     * @return A [JsObject] containing the resolved options.
     */
    fun resolvedOptions(): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("resolvedOptions")))

    companion object {
        /**
         * Returns an array containing those of the provided locales that are supported by the implementation.
         * Corresponds to `Intl.PluralRules.supportedLocalesOf(locales, options)`.
         * @param locales A [JsObject] representing the locale string or array of strings.
         * @param options A [JsObject] representing the plural rules options.
         * @return A [JsObject] representing the array of supported locale strings.
         */
        fun supportedLocalesOf(locales: JsObject, options: JsObject): JsObject =
            JsObject.syntax(ChainOperation(JsObject.syntax("Intl.PluralRules"), InvocationOperation("supportedLocalesOf", locales, options)))
    }
}