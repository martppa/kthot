package net.asere.kthot.js.dsl.type.intl.format.number

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.instantiation.InstantiationOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.obj.JsObject

class JsNumberFormatSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsNumberFormat>(value), JsNumberFormat {
    internal constructor(value: JsElement) : this("$value")
}

fun JsNumberFormat.Companion.syntax(value: String): JsNumberFormat =
    JsNumberFormatSyntax(value)

fun JsNumberFormat.Companion.syntax(value: JsElement): JsNumberFormat =
    JsNumberFormatSyntax(value)

/**
 * Constructs a new NumberFormat object.
 * Corresponds to `new NumberFormat(locales, options)`.
 * @param locales A [JsObject] representing the locale string or array of strings.
 * @param options A [JsObject] representing the number formatting options.
 * @return A new [JsNumberFormat] instance.
 */
fun JsNumberFormat.Companion.new(locales: JsObject, options: JsObject): JsNumberFormat =
    JsNumberFormat.syntax(
        value = InstantiationOperation(
            value = InvocationOperation("Intl.NumberFormat", locales, options)
        )
    )