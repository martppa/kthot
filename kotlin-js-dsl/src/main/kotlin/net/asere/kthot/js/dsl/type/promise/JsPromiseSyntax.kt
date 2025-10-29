package net.asere.kthot.js.dsl.type.promise

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.value.JsValue

@JsInternalApi
class JsPromiseSyntax<T : JsValue>(
    value: String,
    override val typeBuilder: (JsElement) -> T
) : JsReferenceSyntax<JsPromise<T>>(value), JsPromise<T> {
    constructor(value: JsElement, typeBuilder: (JsElement) -> T)
            : this(value = "$value", typeBuilder = typeBuilder)
}

@OptIn(JsInternalApi::class)
fun <T : JsValue> JsPromise.Companion.syntax(
    value: String,
    typeBuilder: (JsElement) -> T,
): JsPromise<T> = JsPromiseSyntax(
    value = value,
    typeBuilder = typeBuilder
)

@OptIn(JsInternalApi::class)
fun <T : JsValue> JsPromise.Companion.syntax(
    value: JsElement,
    typeBuilder: (JsElement) -> T,
): JsPromise<T> = JsPromiseSyntax(
    value = value,
    typeBuilder = typeBuilder,
)

@OptIn(JsInternalApi::class)
inline fun <reified T : JsValue> JsPromise.Companion.syntax(
    value: String,
): JsPromise<T> = JsPromiseSyntax(
    value = value,
    typeBuilder = ::provide
)

@OptIn(JsInternalApi::class)
inline fun <reified T : JsValue> JsPromise.Companion.syntax(
    value: JsElement,
): JsPromise<T> = JsPromiseSyntax(
    value = value,
    typeBuilder = ::provide,
)