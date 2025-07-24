package net.asere.kotlin.js.dsl.types.definition

import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.value.JsValue

interface JsDefinition<T : JsReference<C>, C : JsValue> {
    val reference: T
}