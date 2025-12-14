package net.asere.kthot.js.dsl.dom.type.core.event.target

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement

class JsEventTargetSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsEventTarget>(value), JsEventTarget {
    internal constructor(value: JsElement) : this("$value")
}

fun JsEventTarget.Companion.syntax(value: String): JsEventTarget =
    JsEventTargetSyntax(value)

fun JsEventTarget.Companion.syntax(value: JsElement): JsEventTarget =
    JsEventTargetSyntax(value)

fun JsEventTarget.Companion.syntax(block: JsScope.() -> JsEventTarget): JsEventTarget {
    val scope = JsSyntaxScope()
    scope.block()
    return syntax(scope)
}