package net.asere.kotlin.js.dsl.dom.type.token.list

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsDomTokenListSyntax(value: String) : JsReferenceSyntax<JsDomTokenList>(value), JsDomTokenList {
    constructor(value: JsElement) : this("$value")
}

fun JsDomTokenList.Companion.syntax(value: String): JsDomTokenListSyntax = JsDomTokenListSyntax(value)
fun JsDomTokenList.Companion.syntax(value: JsElement): JsDomTokenListSyntax = JsDomTokenListSyntax(value)