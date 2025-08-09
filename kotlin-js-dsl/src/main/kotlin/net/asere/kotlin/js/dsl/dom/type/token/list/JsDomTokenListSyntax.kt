package net.asere.kotlin.js.dsl.dom.type.token.list

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsDomTokenListSyntax(value: String, isNullable: Boolean) : JsReferenceSyntax<JsDomTokenList>(value, isNullable),
    JsDomTokenList {
    constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsDomTokenList.Companion.syntax(value: String, isNullable: Boolean = false): JsDomTokenListSyntax =
    JsDomTokenListSyntax(value, isNullable)

fun JsDomTokenList.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsDomTokenListSyntax =
    JsDomTokenListSyntax(value, isNullable)