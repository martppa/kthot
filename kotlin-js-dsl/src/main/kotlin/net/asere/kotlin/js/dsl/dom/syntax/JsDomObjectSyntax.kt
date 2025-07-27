package net.asere.kotlin.js.dsl.dom.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.JsDomObject
import net.asere.kotlin.js.dsl.syntax.value.JsReferenceSyntax

class JsDomObjectSyntax(value: String) : JsReferenceSyntax<JsDomObject>(value), JsDomObject {
    constructor(value: JsElement) : this("$value")
}