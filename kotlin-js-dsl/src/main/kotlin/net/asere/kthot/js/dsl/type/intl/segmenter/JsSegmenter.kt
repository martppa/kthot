package net.asere.kthot.js.dsl.type.intl.segmenter

import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString

/**
 * Represents an instance of the JavaScript Intl.Segmenter object.
 * Used for locale-sensitive text segmentation. Extends the base JsObject.
 */
interface JsSegmenter : JsObject {
    /**
     * Returns an iterable segmenter object for a given string.
     * Corresponds to `segmenter.segment(input)`.
     * @param input A [JsString] representing the text to segment.
     * @return A [JsObject] representing the iterable Segmenter instance.
     */
    fun segment(input: JsString): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("segment", input)))

    /**
     * Returns a new object with properties reflecting the locale and segmentation options computed during initialization.
     * Corresponds to `segmenter.resolvedOptions()`.
     * @return A [JsObject] containing the resolved options.
     */
    fun resolvedOptions(): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("resolvedOptions")))

    companion object {

        /**
         * Returns an array containing those of the provided locales that are supported by the implementation.
         * Corresponds to `Intl.Segmenter.supportedLocalesOf(locales, options)`.
         * @param locales A [JsObject] representing the locale string or array of strings.
         * @param options A [JsObject] representing the segmentation options.
         * @return A [JsObject] representing the array of supported locale strings.
         */
        fun supportedLocalesOf(locales: JsObject, options: JsObject): JsObject =
            JsObject.syntax(ChainOperation(JsObject.syntax("Intl.Segmenter"), InvocationOperation("supportedLocalesOf", locales, options)))
    }
}