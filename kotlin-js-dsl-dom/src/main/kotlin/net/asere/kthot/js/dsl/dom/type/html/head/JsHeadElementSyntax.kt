package net.asere.kthot.js.dsl.dom.type.html.head

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement

/**
 * Represents the syntax generation wrapper for a read-only [JsHeadElement] object.
 */
class JsHeadElementSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsHeadElement>(value), JsHeadElement {
    internal constructor(value: JsElement) : this("$value")
}

fun JsHeadElement.Companion.syntax(value: String): JsHeadElement =
    JsHeadElementSyntax(value)

fun JsHeadElement.Companion.syntax(value: JsElement): JsHeadElement =
    JsHeadElementSyntax(value)

fun JsHeadElement.Companion.syntax(block: JsScope.() -> JsHeadElement): JsHeadElement {
    val scope = JsSyntaxScope()
    val element = scope.block()
    return element
}