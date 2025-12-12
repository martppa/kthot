package net.asere.kthot.js.dsl.type.intl.format.time

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.instantiation.InstantiationOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.obj.JsObject

class JsRelativeTimeFormatSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsRelativeTimeFormat>(value), JsRelativeTimeFormat {
    internal constructor(value: JsElement) : this("$value")
}

fun JsRelativeTimeFormat.Companion.syntax(value: String): JsRelativeTimeFormat =
    JsRelativeTimeFormatSyntax(value)

fun JsRelativeTimeFormat.Companion.syntax(value: JsElement): JsRelativeTimeFormat =
    JsRelativeTimeFormatSyntax(value)

/**
 * Constructs a new Intl.RelativeTimeFormat object.
 * Corresponds to `new Intl.RelativeTimeFormat(locales, options)`.
 * @param locales A [JsObject] representing the locale string or array of strings.
 * @param options A [JsObject] representing the relative time formatting options.
 * @return A new [JsRelativeTimeFormat] instance.
 */
fun JsRelativeTimeFormat.Companion.new(locales: JsObject, options: JsObject): JsRelativeTimeFormat =
    JsRelativeTimeFormat.syntax(InstantiationOperation(InvocationOperation("Intl.RelativeTimeFormat", locales, options)))