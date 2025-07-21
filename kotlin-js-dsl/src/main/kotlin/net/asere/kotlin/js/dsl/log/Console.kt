package net.asere.kotlin.js.dsl.log

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.reference.JsObjectRef
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.value.value

object Console : JsObjectRef("console") {
    fun log(element: JsElement) = JsSyntax("${this}.log(${element})")
    fun log(text: String) = JsSyntax("${this}.log(${JsString.value(text)})")
}