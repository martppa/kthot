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
    name: String? = null,
    override val _typeBuilder_: (JsElement) -> T,
) : JsArray<T>, JsValueRef<JsArray<T>>(
    name = name ?: "collection_${ReferenceId.nextRefInt()}",
) {
    override fun toString(): String = present()
}

inline fun <reified T : JsValue> JsArray.Companion.ref(
    name: String? = null,
): JsArrayRef<T> =
    JsArrayRef(name, ::provide)

inline fun <reified T : JsValue> JsArray.Companion.ref(
    element: JsElement,
): JsArrayRef<T> =
    JsArrayRef(element.present(), ::provide)

fun <T : JsValue> JsArray.Companion.ref(
    name: String? = null,
    typeBuilder: (JsElement) -> T
): JsArrayRef<T> =
    JsArrayRef(name, typeBuilder)

fun <T : JsValue> JsArray.Companion.ref(
    element: JsElement,
    typeBuilder: (JsElement) -> T
): JsArrayRef<T> =
    JsArrayRef(element.present(), typeBuilder)

inline fun <reified T : JsValue> JsArray.Companion.def(
    name: String? = null,
    noinline typeBuilder: (JsElement) -> T = ::provide
) = object :
    JsPrintableDefinition<JsArrayRef<T>, JsArray<T>>() {
    override val reference: JsArrayRef<T> = JsArrayRef(name, typeBuilder)
}