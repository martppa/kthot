package net.asere.kthot.js.dsl.dom.type.core.element

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement

class JsDomElementSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsDomElement>(value), JsDomElement {
    internal constructor(value: JsElement) : this("$value")
}

fun JsDomElement.Companion.syntax(value: String): JsDomElement =
    JsDomElementSyntax(value)

fun JsDomElement.Companion.syntax(value: JsElement): JsDomElement =
    JsDomElementSyntax(value)

fun JsDomElement.Companion.syntax(block: JsScope.() -> JsDomElement): JsDomElement {
    val scope = JsSyntaxScope()
    val element = scope.block()
    return element
}