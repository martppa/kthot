package net.asere.kotlin.js.dsl.type.promise

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsPromiseSyntax<T : JsValue> internal constructor(value: String) : JsReferenceSyntax<JsPromise<T>>(value),
    JsPromise<T> {
    internal constructor(value: JsElement) : this("$value")
}

fun <T : JsValue> JsPromise.Companion.syntax(value: String): JsPromiseSyntax<T> = JsPromiseSyntax(value)
fun <T : JsValue> JsPromise.Companion.syntax(value: JsElement): JsPromiseSyntax<T> = JsPromiseSyntax(value)