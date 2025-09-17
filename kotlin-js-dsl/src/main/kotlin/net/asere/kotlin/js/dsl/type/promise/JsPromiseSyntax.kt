package net.asere.kotlin.js.dsl.type.promise

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.value.JsValue

@OptIn(InternalApi::class)
class JsPromiseSyntax<T : JsValue> @InternalApi constructor(
    value: String,
    isNullable: Boolean,
    override val typeBuilder: (JsElement, Boolean) -> T
) : JsReferenceSyntax<JsPromise<T>>(value = value, isNullable = isNullable), JsPromise<T> {
    @InternalApi constructor(
        value: JsElement,
        isNullable: Boolean,
        typeBuilder: (JsElement, Boolean) -> T
    ) : this(value = "$value", isNullable = isNullable, typeBuilder = typeBuilder)
}

@OptIn(InternalApi::class)
inline fun <reified T : JsValue> JsPromise.Companion.syntax(
    value: String,
    isNullable: Boolean = false,
): JsPromiseSyntax<T> = JsPromiseSyntax(
    value = value,
    isNullable = isNullable,
    typeBuilder = ::provide
)

@OptIn(InternalApi::class)
inline fun <reified T : JsValue> JsPromise.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false,
): JsPromiseSyntax<T> = JsPromiseSyntax(
    value = value,
    isNullable = isNullable,
    typeBuilder = ::provide
)

@OptIn(InternalApi::class)
fun <T : JsValue> JsPromise.Companion.syntax(
    value: String,
    isNullable: Boolean = false,
    typeBuilder: (JsElement, Boolean) -> T
): JsPromiseSyntax<T> = JsPromiseSyntax(
    value = value,
    isNullable = isNullable,
    typeBuilder = typeBuilder
)

@OptIn(InternalApi::class)
fun <T : JsValue> JsPromise.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false,
    typeBuilder: (JsElement, Boolean) -> T
): JsPromiseSyntax<T> = JsPromiseSyntax(
    value = value,
    isNullable = isNullable,
    typeBuilder = typeBuilder
)