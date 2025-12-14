package net.asere.kthot.js.dsl.dom.type.core.node

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement

class JsNodeSyntax internal constructor(value: String) :
JsReferenceSyntax<JsNode>(value), JsNode {
    internal constructor(value: JsElement) : this("$value")
}

fun JsNode.Companion.syntax(value: String): JsNode =
    JsNodeSyntax(value)

fun JsNode.Companion.syntax(value: JsElement): JsNode =
    JsNodeSyntax(value)

fun JsNode.Companion.syntax(block: JsScope.() -> JsNode): JsNode {
    val scope = JsSyntaxScope()
    val node = scope.block()
    return node
}