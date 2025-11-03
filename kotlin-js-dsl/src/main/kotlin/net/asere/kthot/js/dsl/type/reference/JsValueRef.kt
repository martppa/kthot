package net.asere.kthot.js.dsl.type.reference

import net.asere.kthot.js.dsl.type.value.JsValue

open class JsValueRef<T : JsValue>(
    name: String? = null,
) : JsReference<T> {

    override val refName: String = name ?: "value_${ReferenceId.nextRefInt()}"

    override fun present(): String = refName

    override fun toString(): String = present()
}