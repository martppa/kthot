package net.asere.kthot.js.dsl.syntax

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsArithmeticalSyntax(value: String) : JsSyntax(value), JsValue {
    constructor(value: JsElement) : this("$value")
}