package net.asere.kotlin.js.dsl.dom.type.structure.paragraph

import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsParagraph].
 */
class JsParagraphSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsParagraph>(value, isNullable), JsParagraph {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsParagraph.Companion.syntax(value: String, isNullable: Boolean = false): JsParagraph =
    JsParagraphSyntax(value, isNullable)

fun JsParagraph.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsParagraph =
    JsParagraphSyntax(value, isNullable)