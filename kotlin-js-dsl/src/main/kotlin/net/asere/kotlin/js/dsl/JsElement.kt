package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.syntax.JsLine
import net.asere.kotlin.js.dsl.syntax.JsSyntax

interface JsElement {
    fun present(): String
}

fun JsElement.toSyntax() = JsSyntax(present())
fun JsElement.toLine() = JsLine(present())