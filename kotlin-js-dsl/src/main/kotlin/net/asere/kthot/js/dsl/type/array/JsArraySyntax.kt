package net.asere.kthot.js.dsl.type.array

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.type.value.JsValue


@OptIn(JsInternalApi::class)
class JsArraySyntax<T : JsValue> @JsInternalApi constructor(
    value: String,
    override val typeBuilder: (JsElement) -> T,
) : JsReferenceSyntax<JsArray<T>>(value), JsArray<T> {
    @JsInternalApi constructor(typeBuilder: (JsElement) -> T, value: JsElement) : this(
        value = "$value",
        typeBuilder = typeBuilder
    )
}

@OptIn(JsInternalApi::class)
inline fun <reified T : JsValue> JsArray.Companion.syntax(
    value: String,
): JsArray<T> = JsArraySyntax(value = value, typeBuilder = ::provide)

@OptIn(JsInternalApi::class)
fun <T : JsValue> JsArray.Companion.syntax(
    value: String,
    typeBuilder: (JsElement) -> T,
): JsArray<T> = JsArraySyntax(value = value, typeBuilder = typeBuilder)

@OptIn(JsInternalApi::class)
inline fun <reified T : JsValue> JsArray.Companion.syntax(
    value: JsElement,
): JsArray<T> = JsArraySyntax(value = value, typeBuilder = ::provide)

@OptIn(JsInternalApi::class)
fun <T : JsValue> JsArray.Companion.syntax(
    value: JsElement,
    typeBuilder: (JsElement) -> T,
): JsArray<T> = JsArraySyntax(value = value, typeBuilder = typeBuilder)