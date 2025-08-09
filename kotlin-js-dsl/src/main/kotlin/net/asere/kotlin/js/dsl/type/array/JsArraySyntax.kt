package net.asere.kotlin.js.dsl.type.array

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsArraySyntax<T : JsValue> internal constructor(
    override val typeBuilder: (JsElement, isNullable: Boolean) -> T,
    value: String,
    isNullable: Boolean
) : JsReferenceSyntax<JsArray<T>>(value, isNullable), JsArray<T> {
    internal constructor(typeBuilder: (JsElement, Boolean) -> T, value: JsElement, isNullable: Boolean) : this(
        typeBuilder,
        "$value",
        isNullable
    )
}

fun <T : JsValue> JsArray.Companion.syntax(
    typeBuilder: (JsElement, isNullable: Boolean) -> T,
    value: String,
    isNullable: Boolean = false
): JsArray<T> = JsArraySyntax(typeBuilder, value, isNullable)

fun <T : JsValue> JsArray.Companion.syntax(
    typeBuilder: (JsElement, isNullable: Boolean) -> T,
    value: JsElement,
    isNullable: Boolean = false
): JsArray<T> = JsArraySyntax(typeBuilder, value, isNullable)