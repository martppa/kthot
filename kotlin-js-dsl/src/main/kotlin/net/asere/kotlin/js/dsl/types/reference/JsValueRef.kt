package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.value.JsValue

open class JsValueRef<T : JsValue>(
    name: String? = null
) : JsReference<T> {

    override val name: String = name ?: "value_${JsReference.nextRefInt()}"

    override fun present(): String = name

    override fun toString(): String = present()
}