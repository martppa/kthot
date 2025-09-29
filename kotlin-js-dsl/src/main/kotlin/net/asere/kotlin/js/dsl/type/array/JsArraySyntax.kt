package net.asere.kotlin.js.dsl.type.array

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue


@OptIn(InternalApi::class)
class JsArraySyntax<T : JsValue> @InternalApi constructor(
    value: String,
    isNullable: Boolean,
    override val typeBuilder: (JsElement, isNullable: Boolean) -> T,
) : JsReferenceSyntax<JsArray<T>>(value, isNullable), JsArray<T> {
    @InternalApi constructor(typeBuilder: (JsElement, Boolean) -> T, value: JsElement, isNullable: Boolean) : this(
        value = "$value",
        isNullable = isNullable,
        typeBuilder = typeBuilder
    )
}

@OptIn(InternalApi::class)
inline fun <reified T : JsValue> JsArray.Companion.syntax(
    value: String,
    isNullable: Boolean = false,
): JsArray<T> = JsArraySyntax(value = value, isNullable = isNullable, typeBuilder = ::provide)

@OptIn(InternalApi::class)
fun <T : JsValue> JsArray.Companion.syntax(
    value: String,
    isNullable: Boolean = false,
    typeBuilder: (JsElement, isNullable: Boolean) -> T,
): JsArray<T> = JsArraySyntax(value = value, isNullable = isNullable, typeBuilder = typeBuilder)

@OptIn(InternalApi::class)
inline fun <reified T : JsValue> JsArray.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false,
): JsArray<T> = JsArraySyntax(value = value, isNullable = isNullable, typeBuilder = ::provide)

@OptIn(InternalApi::class)
fun <T : JsValue> JsArray.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false,
    typeBuilder: (JsElement, isNullable: Boolean) -> T,
): JsArray<T> = JsArraySyntax(value = value, isNullable = isNullable, typeBuilder = typeBuilder)