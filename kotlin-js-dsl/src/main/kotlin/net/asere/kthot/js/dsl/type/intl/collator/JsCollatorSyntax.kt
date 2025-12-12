package net.asere.kthot.js.dsl.type.intl.collator

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.instantiation.InstantiationOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.obj.JsObject

class JsCollatorSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsCollator>(value), JsCollator {
    internal constructor(value: JsElement) : this("$value")
}

fun JsCollator.Companion.syntax(value: String): JsCollator =
    JsCollatorSyntax(value)

fun JsCollator.Companion.syntax(value: JsElement): JsCollator =
    JsCollatorSyntax(value)

/**
 * Constructs a new Intl.Collator object.
 * Corresponds to `new Intl.Collator(locales, options)`.
 * @param locales A [JsObject] representing the locale string or array of strings.
 * @param options A [JsObject] representing the collation options.
 * @return A new [JsCollator] instance.
 */
fun JsCollator.Companion.new(locales: JsObject, options: JsObject): JsCollator =
    JsCollator.syntax(
        InstantiationOperation(
            InvocationOperation("Intl.Collator", locales, options)
        )
    )