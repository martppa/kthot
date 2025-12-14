package net.asere.kthot.js.dsl.dom.type.html.element

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement

class JsHtmlElementSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsHtmlElement>(value), JsHtmlElement {
    internal constructor(value: JsElement) : this("$value")
}

fun JsHtmlElement.Companion.syntax(value: String): JsHtmlElement =
    JsHtmlElementSyntax(value)

fun JsHtmlElement.Companion.syntax(value: JsElement): JsHtmlElement =
    JsHtmlElementSyntax(value)

fun JsHtmlElement.Companion.syntax(block: JsScope.() -> JsHtmlElement): JsHtmlElement {
    val scope = JsSyntaxScope()
    val element = scope.block()
    return element
}