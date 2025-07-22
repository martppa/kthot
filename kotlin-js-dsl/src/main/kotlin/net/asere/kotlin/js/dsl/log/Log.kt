package net.asere.kotlin.js.dsl.log

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.tag.JsDsl

@JsDsl fun JsScriptScope.Log(element: JsElement) = +Console.log(element)
@JsDsl fun JsScriptScope.Log(text: String) = +Console.log(text)