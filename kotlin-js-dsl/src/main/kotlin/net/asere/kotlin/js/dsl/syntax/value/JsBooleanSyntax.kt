package net.asere.kotlin.js.dsl.syntax.value

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.types.type.JsBoolean

class JsBooleanSyntax(value: String) : JsReferenceSyntax<JsBoolean>(value), JsBoolean {
    constructor(value: JsElement) : this("$value")
}