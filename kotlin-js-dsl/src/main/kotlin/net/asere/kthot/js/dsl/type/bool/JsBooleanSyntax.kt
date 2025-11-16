package net.asere.kthot.js.dsl.type.bool

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

class JsBooleanSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsBoolean>(value), JsBoolean {
    internal constructor(value: JsElement) : this("$value")
}

fun JsBoolean.Companion.syntax(value: String): JsBoolean =
    JsBooleanSyntax(value)

fun JsBoolean.Companion.syntax(value: JsElement): JsBoolean =
    JsBooleanSyntax(value)

fun JsBoolean.Companion.syntax(block: JsScope.() -> JsBoolean): JsBoolean {
    val scope = JsSyntaxScope()
    scope.block()
    return syntax(scope)
}