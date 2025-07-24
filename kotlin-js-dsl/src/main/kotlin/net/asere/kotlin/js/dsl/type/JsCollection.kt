package net.asere.kotlin.js.dsl.type

import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsReferenceSyntax
import net.asere.kotlin.js.dsl.value.JsValue

interface JsCollection<T : JsValue> : JsObject {

    companion object

    fun getByIndex(index: JsNumber): JsReference<T> = JsReferenceSyntax.of("${this}[$index]")

    fun getLength(): JsNumberSyntax = JsNumberSyntax("${this}.length")

    fun push(elements: List<T>): JsNumberSyntax {
        val args = elements.joinToString(", ") { "$it" }
        return JsNumberSyntax("${this}.push($args)")
    }

    fun pop(): JsReferenceSyntax<T> = JsReferenceSyntax.of("${this}.pop()")

    fun shift(): JsNumberSyntax = JsNumberSyntax("${this}.shift()")

    fun unshift(elements: List<JsSyntax>): JsNumberSyntax {
        val args = elements.joinToString(", ") { "$it" }
        return JsNumberSyntax("${this}.unshift($args)")
    }

    fun forEach(lambda: JsLambda1<T>): JsSyntax = JsSyntax("${this}.forEach(${lambda})")

    fun map(lambda: JsLambda1<T>): JsSyntax = JsSyntax("${this}.map(${lambda})")

    fun mapIndexed(lambda: JsLambda2<T, JsNumber>): JsSyntax = JsSyntax("${this}.map(${lambda})")
}