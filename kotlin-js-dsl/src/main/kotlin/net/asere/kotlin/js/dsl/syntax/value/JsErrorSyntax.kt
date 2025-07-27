package net.asere.kotlin.js.dsl.syntax.value

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.types.type.JsError

class JsErrorSyntax(value: String) : JsReferenceSyntax<JsError>(value), JsError {
    constructor(value: JsElement) : this("$value")
}