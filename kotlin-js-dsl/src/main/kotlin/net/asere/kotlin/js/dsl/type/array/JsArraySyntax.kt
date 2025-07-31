package net.asere.kotlin.js.dsl.type.array

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsArraySyntax<T : JsValue> internal constructor(value: String) : JsReferenceSyntax<JsArray<T>>(value),
    JsArray<T> {
    internal constructor(value: JsElement) : this("$value")
}

fun <T : JsValue> JsArray.Companion.syntax(value: String): JsArraySyntax<T> = JsArraySyntax(value)