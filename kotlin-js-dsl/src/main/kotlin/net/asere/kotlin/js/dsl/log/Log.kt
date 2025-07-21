package net.asere.kotlin.js.dsl.log

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsScriptScope

fun JsScriptScope.Log(element: JsElement) = +Console.log(element)
fun JsScriptScope.Log(text: String) = +Console.log(text)