package net.asere.kthot.js.dsl.type.reference

import net.asere.kthot.js.dsl.type.value.JsValue

interface JsReference<T : JsValue> : JsValue {
    val name: String
    val isNullable: Boolean
}