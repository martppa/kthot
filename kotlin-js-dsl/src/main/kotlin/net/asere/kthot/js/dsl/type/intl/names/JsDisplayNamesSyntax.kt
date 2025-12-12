package net.asere.kthot.js.dsl.type.intl.names

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.instantiation.InstantiationOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.obj.JsObject

class JsDisplayNamesSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsDisplayNames>(value), JsDisplayNames {
    internal constructor(value: JsElement) : this("$value")
}

fun JsDisplayNames.Companion.syntax(value: String): JsDisplayNames =
    JsDisplayNamesSyntax(value)

fun JsDisplayNames.Companion.syntax(value: JsElement): JsDisplayNames =
    JsDisplayNamesSyntax(value)

/**
 * Constructs a new Intl.DisplayNames object.
 * Corresponds to `new Intl.DisplayNames(locales, options)`.
 * @param locales A [JsObject] representing the locale string or array of strings.
 * @param options A [JsObject] with `type` and `style` properties (e.g., `{ type: "language" }`).
 * @return A new [JsDisplayNames] instance.
 */
fun JsDisplayNames.Companion.new(locales: JsObject, options: JsObject): JsDisplayNames =
    JsDisplayNames.syntax(InstantiationOperation(InvocationOperation("Intl.DisplayNames", locales, options)))