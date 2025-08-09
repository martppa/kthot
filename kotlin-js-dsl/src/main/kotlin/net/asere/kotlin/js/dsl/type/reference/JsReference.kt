package net.asere.kotlin.js.dsl.type.reference

import net.asere.kotlin.js.dsl.type.value.JsValue

interface JsReference<T : JsValue> : JsValue {
    val name: String
    val isNullable: Boolean
}