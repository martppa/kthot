package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.JsString

object JsWindow : JsDomObjectRef("window") {
    fun alert(text: JsString): JsSyntax = JsSyntax("${this}.alert($text)")
}