package net.asere.kthot.js.dsl.type.intl.plural

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.instantiation.InstantiationOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.obj.JsObject

class JsPluralRulesSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsPluralRules>(value), JsPluralRules {
    internal constructor(value: JsElement) : this("$value")
}

fun JsPluralRules.Companion.syntax(value: String): JsPluralRules =
    JsPluralRulesSyntax(value)

fun JsPluralRules.Companion.syntax(value: JsElement): JsPluralRules =
    JsPluralRulesSyntax(value)

/**
 * Constructs a new Intl.PluralRules object.
 * Corresponds to `new Intl.PluralRules(locales, options)`.
 * @param locales A [JsObject] representing the locale string or array of strings.
 * @param options A [JsObject] representing plural rules options.
 * @return A new [JsPluralRules] instance.
 */
fun JsPluralRules.Companion.new(locales: JsObject, options: JsObject): JsPluralRules =
    JsPluralRules.syntax(InstantiationOperation(InvocationOperation("Intl.PluralRules", locales, options)))