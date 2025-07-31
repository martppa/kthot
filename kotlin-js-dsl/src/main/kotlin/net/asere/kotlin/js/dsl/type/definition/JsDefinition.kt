package net.asere.kotlin.js.dsl.type.definition

import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.value.JsValue

interface JsDefinition<T : JsReference<C>, C : JsValue> {
    val reference: T
}