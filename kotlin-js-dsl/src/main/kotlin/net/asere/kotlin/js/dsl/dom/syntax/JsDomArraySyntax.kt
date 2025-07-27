package net.asere.kotlin.js.dsl.dom.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.JsDomArray
import net.asere.kotlin.js.dsl.syntax.value.JsReferenceSyntax

class JsDomArraySyntax(value: String) : JsReferenceSyntax<JsDomArray>(value), JsDomArray {
    constructor(value: JsElement) : this("$value")
}