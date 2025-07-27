package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement

class JsLine(value: String) : JsSyntax(value + "\n") {
    constructor(value: JsElement) : this("$value")
}