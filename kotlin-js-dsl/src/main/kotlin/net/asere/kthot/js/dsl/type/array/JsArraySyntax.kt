package net.asere.kthot.js.dsl.type.array

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.value.JsValue


@OptIn(JsInternalApi::class)
class JsArraySyntax<T : JsValue> @JsInternalApi constructor(
    value: String,
    isNullable: Boolean,
    override val typeBuilder: (JsElement, isNullable: Boolean) -> T,
) : JsReferenceSyntax<JsArray<T>>(value, isNullable), JsArray<T> {
    @JsInternalApi constructor(typeBuilder: (JsElement, Boolean) -> T, value: JsElement, isNullable: Boolean) : this(
        value = "$value",
        isNullable = isNullable,
        typeBuilder = typeBuilder
    )
}

@OptIn(JsInternalApi::class)
inline fun <reified T : JsValue> JsArray.Companion.syntax(
    value: String,
    isNullable: Boolean = false,
): JsArray<T> = JsArraySyntax(value = value, isNullable = isNullable, typeBuilder = ::provide)

@OptIn(JsInternalApi::class)
fun <T : JsValue> JsArray.Companion.syntax(
    value: String,
    isNullable: Boolean = false,
    typeBuilder: (JsElement, isNullable: Boolean) -> T,
): JsArray<T> = JsArraySyntax(value = value, isNullable = isNullable, typeBuilder = typeBuilder)

@OptIn(JsInternalApi::class)
inline fun <reified T : JsValue> JsArray.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false,
): JsArray<T> = JsArraySyntax(value = value, isNullable = isNullable, typeBuilder = ::provide)

@OptIn(JsInternalApi::class)
fun <T : JsValue> JsArray.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false,
    typeBuilder: (JsElement, isNullable: Boolean) -> T,
): JsArray<T> = JsArraySyntax(value = value, isNullable = isNullable, typeBuilder = typeBuilder)