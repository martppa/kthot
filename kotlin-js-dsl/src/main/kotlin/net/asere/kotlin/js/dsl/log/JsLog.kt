package net.asere.kotlin.js.dsl.log

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsLine
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.value.value

fun jsLog(element: JsElement) = JsLine("console.log(${element})")

fun jsLog(text: String) = JsLine("console.log(${JsString.value(text)})")