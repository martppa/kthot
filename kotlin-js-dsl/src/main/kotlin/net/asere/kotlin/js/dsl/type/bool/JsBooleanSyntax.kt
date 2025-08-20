package net.asere.kotlin.js.dsl.type.bool

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsBooleanSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsBoolean>(value, isNullable), JsBoolean {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsBoolean.Companion.syntax(value: String, isNullable: Boolean = false): JsBooleanSyntax =
    JsBooleanSyntax(value, isNullable)

fun JsBoolean.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsBooleanSyntax =
    JsBooleanSyntax(value, isNullable)