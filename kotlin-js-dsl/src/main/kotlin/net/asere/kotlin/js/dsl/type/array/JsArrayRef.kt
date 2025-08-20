package net.asere.kotlin.js.dsl.type.array

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsArrayRef<T : JsValue> @InternalApi constructor(
    override val typeBuilder: (JsElement, isNullable: Boolean) -> T,
    name: String? = null,
    isNullable: Boolean = false,
) : JsArray<T>, JsValueRef<JsArray<T>>(
    name = name ?: "collection_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

@OptIn(InternalApi::class)
inline fun <reified T : JsValue> JsArray.Companion.ref(
    name: String? = null,
    isNullable: Boolean = false,
    noinline typeBuilder: (JsElement, isNullable: Boolean) -> T = ::provide
): JsArrayRef<T> =
    JsArrayRef(typeBuilder, name, isNullable)

@OptIn(InternalApi::class)
inline fun <reified T : JsValue> JsArray.Companion.def(
    name: String? = null,
    isNullable: Boolean = false,
    noinline typeBuilder: (JsElement, isNullable: Boolean) -> T = ::provide
) = object :
    JsPrintableDefinition<JsArrayRef<T>, JsArray<T>>() {
    override val reference: JsArrayRef<T> = JsArrayRef(typeBuilder, name, isNullable)
}