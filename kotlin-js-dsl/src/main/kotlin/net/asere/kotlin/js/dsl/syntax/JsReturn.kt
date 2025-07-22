package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.tag.JsDsl

@JsDsl
fun JsScriptScope.Return(element: JsElement) = +jsReturn(element)

fun jsReturn(element: JsElement) = JsSyntax("return $element")