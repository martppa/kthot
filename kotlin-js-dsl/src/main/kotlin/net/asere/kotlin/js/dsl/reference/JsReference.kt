package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.value.JsValue

interface JsReference<T : JsValue> : JsValue {
    val id: String
    val name: String
}