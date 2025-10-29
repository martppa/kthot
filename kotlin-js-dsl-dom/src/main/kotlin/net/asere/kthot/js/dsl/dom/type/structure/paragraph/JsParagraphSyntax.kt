package net.asere.kthot.js.dsl.dom.type.structure.paragraph

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsParagraph].
 */
class JsParagraphSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsParagraph>(value), JsParagraph {
    internal constructor(value: JsElement) : this("$value")
}

fun JsParagraph.Companion.syntax(value: String): JsParagraph =
    JsParagraphSyntax(value)

fun JsParagraph.Companion.syntax(value: JsElement): JsParagraph =
    JsParagraphSyntax(value)