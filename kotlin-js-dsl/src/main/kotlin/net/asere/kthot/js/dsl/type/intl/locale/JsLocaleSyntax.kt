package net.asere.kthot.js.dsl.type.intl.locale

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.instantiation.InstantiationOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.string.JsString

class JsLocaleSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsLocale>(value), JsLocale {
    internal constructor(value: JsElement) : this("$value")
}

fun JsLocale.Companion.syntax(value: String): JsLocale =
    JsLocaleSyntax(value)

fun JsLocale.Companion.syntax(value: JsElement): JsLocale =
    JsLocaleSyntax(value)

/**
 * Constructs a new Intl.Locale object.
 * Corresponds to `new Intl.Locale(tag, options)`.
 * @param tag A [JsString] representing the BCP 47 language tag.
 * @param options A [JsObject] representing options for the locale (e.g., script, region).
 * @return A new [JsLocale] instance.
 */
fun JsLocale.Companion.new(tag: JsString, options: JsObject): JsLocale =
    JsLocale.syntax(InstantiationOperation(InvocationOperation("Intl.Locale", tag, options)))