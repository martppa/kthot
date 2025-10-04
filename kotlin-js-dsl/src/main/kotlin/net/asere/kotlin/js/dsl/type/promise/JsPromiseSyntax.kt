package net.asere.kotlin.js.dsl.type.promise

import net.asere.kotlin.js.dsl.annotation.JsInternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsInternalApi
class JsPromiseSyntax<T : JsValue>(
    value: String,
    isNullable: Boolean,
    override val typeBuilder: (JsElement, Boolean) -> T
) : JsReferenceSyntax<JsPromise<T>>(value, isNullable), JsPromise<T> {
    constructor(value: JsElement, isNullable: Boolean, typeBuilder: (JsElement, Boolean) -> T)
            : this(value = "$value", isNullable = isNullable, typeBuilder = typeBuilder)
}

@OptIn(JsInternalApi::class)
fun <T : JsValue> JsPromise.Companion.syntax(
    value: String,
    isNullable: Boolean = false,
    typeBuilder: (JsElement, isNullable: Boolean) -> T,
): JsPromise<T> = JsPromiseSyntax(
    value = value,
    isNullable = isNullable,
    typeBuilder = typeBuilder
)

@OptIn(JsInternalApi::class)
fun <T : JsValue> JsPromise.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false,
    typeBuilder: (JsElement, isNullable: Boolean) -> T,
): JsPromise<T> = JsPromiseSyntax(
    value = value,
    isNullable = isNullable,
    typeBuilder = typeBuilder,
)

@OptIn(JsInternalApi::class)
inline fun <reified T : JsValue> JsPromise.Companion.syntax(
    value: String,
    isNullable: Boolean = false,
): JsPromise<T> = JsPromiseSyntax(
    value = value,
    isNullable = isNullable,
    typeBuilder = ::provide
)

@OptIn(JsInternalApi::class)
inline fun <reified T : JsValue> JsPromise.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false,
): JsPromise<T> = JsPromiseSyntax(
    value = value,
    isNullable = isNullable,
    typeBuilder = ::provide,
)