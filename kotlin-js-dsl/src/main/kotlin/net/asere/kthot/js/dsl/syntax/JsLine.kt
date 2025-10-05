package net.asere.kthot.js.dsl.syntax

import net.asere.kthot.js.dsl.type.JsElement

class JsLine(value: String) : JsSyntax(value + "\n") {
    constructor(value: JsElement) : this("$value")
}