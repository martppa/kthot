package net.asere.kotlin.js.dsl.type.promise

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsPromiseSyntax<T : JsValue> internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsPromise<T>>(value, isNullable),
    JsPromise<T> {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun <T : JsValue> JsPromise.Companion.syntax(value: String, isNullable: Boolean = false): JsPromise<T> =
    JsPromiseSyntax(value, isNullable)

fun <T : JsValue> JsPromise.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsPromise<T> =
    JsPromiseSyntax(value, isNullable)