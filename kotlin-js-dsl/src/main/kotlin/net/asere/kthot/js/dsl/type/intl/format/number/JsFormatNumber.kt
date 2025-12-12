package net.asere.kthot.js.dsl.type.intl.format.number

import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.array.syntax
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents an instance of the JavaScript Intl.NumberFormat object, used for
 * language-sensitive number formatting. Extends the base JsObject.
 */
interface JsNumberFormat : JsObject {

    /**
     * Formats a number according to the object's locale and formatting options.
     * Corresponds to `formatter.format(number)`.
     * @param number The number to format as a [JsNumber].
     * @return A [JsString] representing the formatted number.
     */
    fun format(number: JsNumber): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("format", number)))

    /**
     * Returns an array of objects representing the number string in parts.
     * Corresponds to `formatter.formatToParts(number)`.
     * @param number The number to format as a [JsNumber].
     * @return A [JsArray<JsObject>] representing the array of format parts.
     */
    fun formatToParts(number: JsNumber): JsArray<JsObject> =
        JsArray.syntax(ChainOperation(this, InvocationOperation("formatToParts", number)))

    /**
     * Returns a new object with properties reflecting the locale and number formatting options.
     * Corresponds to `formatter.resolvedOptions()`.
     * @return A [JsObject] containing the resolved options.
     */
    fun resolvedOptions(): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("resolvedOptions")))

    companion object
}