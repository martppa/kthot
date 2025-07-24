package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.types.reference.JsObjectRef
import net.asere.kotlin.js.dsl.types.reference.JsValueRef
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.types.type.JsString

object JsWindow : JsObjectRef("window") {
    fun alert(text: JsString): JsSyntax = JsSyntax("${this}.alert($text)")
}