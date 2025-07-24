package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.types.reference.lambda.JsLambda1Ref
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsDomObjectSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.JsString
import net.asere.kotlin.js.dsl.types.type.js

interface JsDomCollection : JsObject {
    fun getByIndex(index: JsNumber): JsSyntax = JsSyntax("${this}[$index]")
    fun getLength(): JsNumberSyntax = JsNumberSyntax("${this}.length")
    fun getItem(index: JsNumber): JsDomObjectSyntax = JsDomObjectSyntax("${this}.item($index)")
    fun namedItem(name: JsString): JsDomObjectSyntax = JsDomObjectSyntax("${this}.namedItem($name)")
    fun namedItem(name: String): JsDomObjectSyntax = namedItem(name.js)
    fun forEach(callback: JsLambda1Ref<JsObject>): JsSyntax = JsSyntax("${this}.forEach($callback)")

    companion object
}