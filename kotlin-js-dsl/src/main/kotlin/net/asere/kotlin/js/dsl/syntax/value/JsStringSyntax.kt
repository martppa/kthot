package net.asere.kotlin.js.dsl.syntax.value

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.types.type.JsString

class JsStringSyntax(value: String) : JsReferenceSyntax<JsString>(value), JsString {
    constructor(value: JsElement) : this("$value")
}