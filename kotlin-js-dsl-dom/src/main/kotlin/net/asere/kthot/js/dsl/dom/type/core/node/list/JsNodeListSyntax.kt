package net.asere.kthot.js.dsl.dom.type.core.node.list

import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement

class JsNodeListSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsNodeList>(value), JsNodeList {
    internal constructor(value: JsElement) : this("$value")
}

fun JsNodeList.Companion.syntax(value: String): JsNodeList =
    JsNodeListSyntax(value)

fun JsNodeList.Companion.syntax(value: JsElement): JsNodeList =
    JsNodeListSyntax(value)

fun JsNodeList.Companion.syntax(block: JsScope.() -> JsNodeList): JsNodeList {
    val scope = JsSyntaxScope()
    val nodeList = scope.block()
    return nodeList
}