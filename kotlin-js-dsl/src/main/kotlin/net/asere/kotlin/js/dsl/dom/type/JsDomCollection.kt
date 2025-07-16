package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.value.JsNumberValue
import net.asere.kotlin.js.dsl.value.JsValue

abstract class JsDomCollection : JsValue {
    fun getByIndex(index: JsNumberValue): JsSyntax = JsSyntax("${this}[$index]")
    fun getLength(): JsSyntax = JsSyntax("${this}.length")
    fun getItem(index: JsNumberValue): JsSyntax = JsSyntax("${this}.item($index)")

    override fun toString(): String = present()
}