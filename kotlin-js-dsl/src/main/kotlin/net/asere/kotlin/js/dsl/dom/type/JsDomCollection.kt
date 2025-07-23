package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.reference.JsLambda1Ref
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsDomObjectSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.type.JsObject
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.type.js
import net.asere.kotlin.js.dsl.value.JsValue

interface JsDomCollection : JsValue {
    fun getByIndex(index: JsNumber): JsSyntax = JsSyntax("${this}[$index]")
    fun getLength(): JsNumberSyntax = JsNumberSyntax("${this}.length")
    fun getItem(index: JsNumber): JsDomObjectSyntax = JsDomObjectSyntax("${this}.item($index)")
    fun namedItem(name: JsString): JsDomObjectSyntax = JsDomObjectSyntax("${this}.namedItem($name)")
    fun namedItem(name: String): JsDomObjectSyntax = namedItem(name.js)
    fun forEach(callback: JsLambda1Ref<JsObject>): JsSyntax = JsSyntax("${this}.forEach($callback)")
}