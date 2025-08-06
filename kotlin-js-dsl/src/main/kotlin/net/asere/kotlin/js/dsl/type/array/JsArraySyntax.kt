package net.asere.kotlin.js.dsl.type.array

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsArraySyntax<T : JsValue> internal constructor(
    override val typeBuilder: (JsElement) -> T,
    value: String
) : JsReferenceSyntax<JsArray<T>>(value),
    JsArray<T> {
    internal constructor(typeBuilder: (JsElement) -> T, value: JsElement) : this(typeBuilder, "$value")
}

fun <T : JsValue> JsArray.Companion.syntax(
    genericTypeBuilder: (JsElement) -> T,
    value: String,
): JsArraySyntax<T> = JsArraySyntax(genericTypeBuilder, value)

fun <T : JsValue> JsArray.Companion.syntax(
    genericTypeBuilder: (JsElement) -> T,
    value: JsElement,
): JsArraySyntax<T> = JsArraySyntax(genericTypeBuilder, value)