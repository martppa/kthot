package net.asere.kthot.js.dsl.type.intl.format.date

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.instantiation.InstantiationOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.obj.JsObject

class JsDateTimeFormatSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsDateTimeFormat>(value), JsDateTimeFormat {
    internal constructor(value: JsElement) : this("$value")
}

fun JsDateTimeFormat.Companion.syntax(value: String): JsDateTimeFormat =
    JsDateTimeFormatSyntax(value)

fun JsDateTimeFormat.Companion.syntax(value: JsElement): JsDateTimeFormat =
    JsDateTimeFormatSyntax(value)

/**
 * Constructs a new Intl.DateTimeFormat object.
 * Corresponds to `new Intl.DateTimeFormat(locales, options)`.
 * @param locales A [JsObject] representing the locale string or array of strings.
 * @param options A [JsObject] representing the date/time formatting options.
 * @return A new [JsDateTimeFormat] instance.
 */
fun JsDateTimeFormat.Companion.new(locales: JsObject, options: JsObject): JsDateTimeFormat =
    JsDateTimeFormat.syntax(
        InstantiationOperation(
            InvocationOperation("Intl.DateTimeFormat", locales, options)
        )
    )