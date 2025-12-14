package net.asere.kthot.js.dsl.dom.type.html.paragraph

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

/**
 * A [JsSyntax] implementation specifically for [JsParagraphElement].
 */
class JsParagraphElementSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsParagraphElement>(value), JsParagraphElement {
    internal constructor(value: JsElement) : this("$value")
}

fun JsParagraphElement.Companion.syntax(value: String): JsParagraphElement =
    JsParagraphElementSyntax(value)

fun JsParagraphElement.Companion.syntax(value: JsElement): JsParagraphElement =
    JsParagraphElementSyntax(value)