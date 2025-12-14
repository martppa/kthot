package net.asere.kthot.js.dsl.dom.type.html.body

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement

/**
 * Represents the syntax generation wrapper for a read-only [JsBodyElement] object.
 */
class JsBodyElementSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsBodyElement>(value), JsBodyElement {
    internal constructor(value: JsElement) : this("$value")
}

/**
 * Creates a [JsBodyElement] object from a raw JavaScript string representing its syntax.
 */
fun JsBodyElement.Companion.syntax(value: String): JsBodyElement =
    JsBodyElementSyntax(value)

/**
 * Creates a [JsBodyElement] object from a generic Kthot element representing its syntax.
 */
fun JsBodyElement.Companion.syntax(value: JsElement): JsBodyElement =
    JsBodyElementSyntax(value)

/**
 * Executes a block of code within a [JsSyntaxScope] and returns the resulting [JsBodyElement].
 */
fun JsBodyElement.Companion.syntax(block: JsScope.() -> JsBodyElement): JsBodyElement {
    val scope = JsSyntaxScope()
    val element = scope.block()
    return element
}