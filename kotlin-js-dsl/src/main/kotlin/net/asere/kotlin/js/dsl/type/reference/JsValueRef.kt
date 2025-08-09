package net.asere.kotlin.js.dsl.type.reference

import net.asere.kotlin.js.dsl.type.value.JsValue

open class JsValueRef<T : JsValue>(
    name: String? = null,
    override val isNullable: Boolean
) : JsReference<T> {

    override val name: String = name ?: "value_${ReferenceId.nextRefInt()}"

    override fun present(): String = name

    override fun toString(): String = present()
}