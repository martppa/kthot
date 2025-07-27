package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.type.JsArray
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsArrayRef<T : JsValue> internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsArray<T>, JsValueRef<JsArray<T>>(
    name = name ?: "collection_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

fun <T : JsValue> JsArray.Companion.ref(name: String? = null, isNullable: Boolean = false): JsArrayRef<T> =
    JsArrayRef(name, isNullable)

fun <T : JsValue> JsArray.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsArrayRef<T>, JsArray<T>>() {
    override val reference: JsArrayRef<T> = JsArrayRef(name)
}