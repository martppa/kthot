package net.asere.kthot.js.dsl.dom.type.data.token.list

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsDomTokenListSyntax(value: String, isNullable: Boolean) : JsReferenceSyntax<JsDomTokenList>(value, isNullable),
    JsDomTokenList {
    constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsDomTokenList.Companion.syntax(value: String, isNullable: Boolean = false): JsDomTokenList =
    JsDomTokenListSyntax(value, isNullable)

fun JsDomTokenList.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsDomTokenList =
    JsDomTokenListSyntax(value, isNullable)