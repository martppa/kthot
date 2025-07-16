package net.asere.kotlin.js.dsl.type

import net.asere.kotlin.js.dsl.callable.JsLambda1
import net.asere.kotlin.js.dsl.callable.JsLambda2
import net.asere.kotlin.js.dsl.reference.JsNumberRef
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.value.JsNumberValue
import net.asere.kotlin.js.dsl.value.JsValue

abstract class JsCollection<T : JsValue> : JsValue {

    companion object

    fun getByIndex(index: JsNumberValue): JsSyntax = JsSyntax("${this}[$index]")

    fun getLength(): JsSyntax = JsSyntax("${this}.length")

    fun push(elements: List<T>): JsSyntax {
        val args = elements.joinToString(", ") { "$it" }
        return JsSyntax("${this}.push($args)")
    }

    fun pop(): JsSyntax = JsSyntax("${this}.pop()")

    fun shift(): JsSyntax = JsSyntax("${this}.shift()")

    fun unshift(elements: List<JsSyntax>): JsSyntax {
        val args = elements.joinToString(", ") { "$it" }
        return JsSyntax("${this}.unshift($args)")
    }

    fun forEach(lambda: JsLambda1<T>): JsSyntax = JsSyntax("${this}.forEach(${lambda})")

    fun map(lambda: JsLambda1<T>): JsSyntax = JsSyntax("${this}.map(${lambda})")

    fun mapIndexed(lambda: JsLambda2<T, JsNumberRef>): JsSyntax = JsSyntax("${this}.map(${lambda})")

    override fun toString(): String = present()
}