package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.id.generateId
import net.asere.kotlin.js.dsl.value.JsValue

open class JsValueRef<T : JsValue>(
    name: String? = null
) : JsDeclarableReference<T> {

    final override val id: String = generateId()
    override val name: String = name ?: "value_$id"

    override fun present(): String = name

    override fun toString(): String = present()
}