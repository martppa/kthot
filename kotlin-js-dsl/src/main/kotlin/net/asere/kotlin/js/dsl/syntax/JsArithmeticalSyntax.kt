package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsArithmeticalSyntax(value: String) : JsSyntax(value), JsValue {
    constructor(value: JsElement) : this("$value")
}