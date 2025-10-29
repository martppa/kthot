@file:OptIn(JsInternalApi::class)

package net.asere.kthot.js.dsl.type.array

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

class JsArrayRef<T : JsValue> @JsInternalApi constructor(
    override val typeBuilder: (JsElement) -> T,
    name: String? = null,
) : JsArray<T>, JsValueRef<JsArray<T>>(
    name = name ?: "collection_${ReferenceId.nextRefInt()}",
) {
    override fun toString(): String = present()
}

inline fun <reified T : JsValue> JsArray.Companion.ref(
    name: String? = null,
    noinline typeBuilder: (JsElement) -> T = ::provide
): JsArrayRef<T> =
    JsArrayRef(typeBuilder, name)

inline fun <reified T : JsValue> JsArray.Companion.ref(
    element: JsElement,
    noinline typeBuilder: (JsElement) -> T = ::provide
): JsArrayRef<T> =
    JsArrayRef(typeBuilder, element.present())

inline fun <reified T : JsValue> JsArray.Companion.def(
    name: String? = null,
    noinline typeBuilder: (JsElement) -> T = ::provide
) = object :
    JsPrintableDefinition<JsArrayRef<T>, JsArray<T>>() {
    override val reference: JsArrayRef<T> = JsArrayRef(typeBuilder, name)
}