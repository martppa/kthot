package net.asere.kthot.js.dsl.type.intl.segmenter

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.instantiation.InstantiationOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.obj.JsObject

class JsSegmenterSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsSegmenter>(value), JsSegmenter {
    internal constructor(value: JsElement) : this("$value")
}

fun JsSegmenter.Companion.syntax(value: String): JsSegmenter =
    JsSegmenterSyntax(value)

fun JsSegmenter.Companion.syntax(value: JsElement): JsSegmenter =
    JsSegmenterSyntax(value)

/**
 * Constructs a new Intl.Segmenter object.
 * Corresponds to `new Intl.Segmenter(locales, options)`.
 * @param locales A [JsObject] representing the locale string or array of strings.
 * @param options A [JsObject] specifying the segmentation granularity (`granularity: "word"`, `"sentence"`, or `"grapheme"`).
 * @return A new [JsSegmenter] instance.
 */
fun JsSegmenter.Companion.new(locales: JsObject, options: JsObject): JsSegmenter =
    JsSegmenter.syntax(InstantiationOperation(InvocationOperation("Intl.Segmenter", locales, options)))