package net.asere.kthot.js.dsl.type.definition

import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.value.JsValue

interface JsDefinition<T : JsReference<C>, C : JsValue> {
    val reference: T
}