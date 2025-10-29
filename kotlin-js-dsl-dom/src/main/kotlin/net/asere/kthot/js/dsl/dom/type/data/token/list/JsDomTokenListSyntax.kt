package net.asere.kthot.js.dsl.dom.type.data.token.list

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsDomTokenListSyntax(value: String) : JsReferenceSyntax<JsDomTokenList>(value),
    JsDomTokenList {
    constructor(value: JsElement) : this("$value")
}

fun JsDomTokenList.Companion.syntax(value: String): JsDomTokenList =
    JsDomTokenListSyntax(value)

fun JsDomTokenList.Companion.syntax(value: JsElement): JsDomTokenList =
    JsDomTokenListSyntax(value)