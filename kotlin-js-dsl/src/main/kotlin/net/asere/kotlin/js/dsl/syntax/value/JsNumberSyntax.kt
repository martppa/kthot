package net.asere.kotlin.js.dsl.syntax.value

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.types.type.JsNumber

class JsNumberSyntax(value: String) : JsReferenceSyntax<JsNumber>(value), JsNumber {
    constructor(value: JsElement) : this("$value")
}