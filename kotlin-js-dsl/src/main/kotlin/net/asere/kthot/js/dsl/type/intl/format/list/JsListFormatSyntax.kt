package net.asere.kthot.js.dsl.type.intl.format.list

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.instantiation.InstantiationOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.obj.JsObject

class JsListFormatSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsListFormat>(value), JsListFormat {
    internal constructor(value: JsElement) : this("$value")
}

fun JsListFormat.Companion.syntax(value: String): JsListFormat =
    JsListFormatSyntax(value)

fun JsListFormat.Companion.syntax(value: JsElement): JsListFormat =
    JsListFormatSyntax(value)

/**
 * Constructs a new Intl.ListFormat object.
 * Corresponds to `new Intl.ListFormat(locales, options)`.
 * @param locales A [JsObject] representing the locale string or array of strings.
 * @param options A [JsObject] representing the list formatting options.
 * @return A new [JsListFormat] instance.
 */
fun JsListFormat.Companion.new(locales: JsObject, options: JsObject): JsListFormat =
    JsListFormat.syntax(InstantiationOperation(InvocationOperation("Intl.ListFormat", locales, options)))