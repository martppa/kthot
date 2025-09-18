package net.asere.kotlin.js.dsl.type

import net.asere.kotlin.js.dsl.syntax.JsLine
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.syntax

interface JsElement {
    fun present(): String
}

fun JsElement.toSyntax() = JsSyntax(present())
fun JsElement.toLine() = JsLine(present())
fun JsElement.isNullable() = this is JsReference<*> && this.isNullable
fun JsElement.toJsString() = JsString.syntax(this)