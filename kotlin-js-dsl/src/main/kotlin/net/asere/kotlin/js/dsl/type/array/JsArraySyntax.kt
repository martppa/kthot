package net.asere.kotlin.js.dsl.type.array

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsArraySyntax<T : JsValue> @InternalApi constructor(
    override val typeBuilder: (JsElement, isNullable: Boolean) -> T,
    value: String,
    isNullable: Boolean
) : JsReferenceSyntax<JsArray<T>>(value, isNullable), JsArray<T> {
    @InternalApi constructor(typeBuilder: (JsElement, Boolean) -> T, value: JsElement, isNullable: Boolean) : this(
        typeBuilder,
        "$value",
        isNullable
    )
}

@OptIn(InternalApi::class)
inline fun <reified T : JsValue> JsArray.Companion.syntax(
    value: String,
    isNullable: Boolean = false,
): JsArray<T> = JsArraySyntax(::provide, value, isNullable)

@OptIn(InternalApi::class)
fun <T : JsValue> JsArray.Companion.syntax(
    typeBuilder: (JsElement, isNullable: Boolean) -> T,
    value: String,
    isNullable: Boolean = false,
): JsArray<T> = JsArraySyntax(typeBuilder, value, isNullable)

@OptIn(InternalApi::class)
inline fun <reified T : JsValue> JsArray.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false,
): JsArray<T> = JsArraySyntax(::provide, value, isNullable)

@OptIn(InternalApi::class)
fun <T : JsValue> JsArray.Companion.syntax(
    typeBuilder: (JsElement, isNullable: Boolean) -> T,
    value: JsElement,
    isNullable: Boolean = false,
): JsArray<T> = JsArraySyntax(typeBuilder, value, isNullable)