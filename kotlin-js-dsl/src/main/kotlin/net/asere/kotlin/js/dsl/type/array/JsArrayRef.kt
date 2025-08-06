package net.asere.kotlin.js.dsl.type.array

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsArrayRef<T : JsValue> internal constructor(
    override val typeBuilder: (JsElement) -> T,
    name: String? = null,
    isNullable: Boolean = false,
) : JsArray<T>, JsValueRef<JsArray<T>>(
    name = name ?: "collection_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

fun <T : JsValue> JsArray.Companion.ref(
    typeBuilder: (JsElement) -> T,
    name: String? = null,
    isNullable: Boolean = false,
): JsArrayRef<T> =
    JsArrayRef(typeBuilder, name, isNullable)

fun <T : JsValue> JsArray.Companion.def(
    typeBuilder: (JsElement) -> T,
    name: String? = null,
    isNullable: Boolean = false,
) = object :
    JsPrintableDefinition<JsArrayRef<T>, JsArray<T>>() {
    override val reference: JsArrayRef<T> = JsArrayRef(typeBuilder, name, isNullable)
}