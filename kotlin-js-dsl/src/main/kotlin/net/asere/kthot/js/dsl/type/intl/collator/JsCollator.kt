package net.asere.kthot.js.dsl.type.intl.collator

import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString

/**
 * Represents an instance of the JavaScript Intl.Collator object, used for
 * language-sensitive string comparison. Extends the base JsObject.
 */
interface JsCollator : JsObject {

    /**
     * Compares two strings according to the collator's locale and options.
     * Corresponds to `collator.compare(string1, string2)`.
     * @param string1 The first string to compare as a [JsString].
     * @param string2 The second string to compare as a [JsString].
     * @return A [JsNumber] indicating the sort order (-1, 0, or 1).
     */
    fun compare(string1: JsString, string2: JsString): JsNumber =
        JsNumber.syntax(ChainOperation(this, InvocationOperation("compare", string1, string2)))

    /**
     * Returns a new object with properties reflecting the locale and collation options computed during initialization.
     * Corresponds to `collator.resolvedOptions()`.
     * @return A [JsObject] containing the resolved options.
     */
    fun resolvedOptions(): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("resolvedOptions")))

    companion object
}