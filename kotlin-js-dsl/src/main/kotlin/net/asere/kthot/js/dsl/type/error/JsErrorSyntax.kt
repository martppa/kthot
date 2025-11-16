package net.asere.kthot.js.dsl.type.error

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.syntax

class JsErrorSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsError>(value), JsError {
    internal constructor(value: JsElement) : this("$value")
}

fun JsError.Companion.syntax(value: String): JsError =
    JsErrorSyntax(value)

fun JsError.Companion.syntax(value: JsElement): JsError =
    JsErrorSyntax(value)

fun JsError.Companion.syntax(block: JsScope.() -> JsError): JsError {
    val scope = JsSyntaxScope()
    scope.block()
    return syntax(scope)
}