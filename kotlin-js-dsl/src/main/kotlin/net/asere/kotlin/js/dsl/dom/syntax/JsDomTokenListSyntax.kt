package net.asere.kotlin.js.dsl.dom.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.JsDomTokenList
import net.asere.kotlin.js.dsl.syntax.value.JsReferenceSyntax

class JsDomTokenListSyntax(value: String) : JsReferenceSyntax<JsDomTokenList>(value), JsDomTokenList {
    constructor(value: JsElement) : this("$value")
}