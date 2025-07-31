package net.asere.kotlin.js.dsl.type.bool

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsBooleanSyntax internal constructor(value: String) : JsReferenceSyntax<JsBoolean>(value), JsBoolean {
    internal constructor(value: JsElement) : this("$value")
}

fun JsBoolean.Companion.syntax(value: String): JsBooleanSyntax = JsBooleanSyntax(value)