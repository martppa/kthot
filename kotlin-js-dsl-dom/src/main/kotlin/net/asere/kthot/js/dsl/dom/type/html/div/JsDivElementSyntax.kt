package net.asere.kthot.js.dsl.dom.type.html.div

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement

class JsDivElementSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsDivElement>(value), JsDivElement {
    internal constructor(value: JsElement) : this("$value")
}

fun JsDivElement.Companion.syntax(value: String): JsDivElement =
    JsDivElementSyntax(value)

fun JsDivElement.Companion.syntax(value: JsElement): JsDivElement =
    JsDivElementSyntax(value)

fun JsDivElement.Companion.syntax(block: JsScope.() -> JsDivElement): JsDivElement {
    val scope = JsSyntaxScope()
    val element = scope.block()
    return element
}