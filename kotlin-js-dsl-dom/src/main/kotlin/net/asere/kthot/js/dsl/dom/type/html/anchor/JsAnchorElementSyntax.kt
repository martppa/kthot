package net.asere.kthot.js.dsl.dom.type.html.anchor

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsAnchorElementSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsAnchorElement>(value), JsAnchorElement {
    internal constructor(value: JsElement) : this("$value")
}

fun JsAnchorElement.Companion.syntax(value: String): JsAnchorElement =
    JsAnchorElementSyntax(value)

fun JsAnchorElement.Companion.syntax(value: JsElement): JsAnchorElement =
    JsAnchorElementSyntax(value)