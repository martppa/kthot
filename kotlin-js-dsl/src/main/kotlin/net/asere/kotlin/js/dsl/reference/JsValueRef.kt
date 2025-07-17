package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.value.JsValue

open class JsValueRef<T : JsValue>(
    name: String? = null
) : JsDeclarableReference<T> {

    override val name: String = name ?: "value_${JsReference.nextRefInt()}"

    override fun present(): String = name

    override fun toString(): String = present()
}