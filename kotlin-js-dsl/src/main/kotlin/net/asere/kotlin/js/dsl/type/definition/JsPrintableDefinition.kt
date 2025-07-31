package net.asere.kotlin.js.dsl.type.definition

import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.value.JsValue

abstract class JsPrintableDefinition<T : JsReference<C>, C : JsValue> : JsDefinition<T, C> {
    override fun toString(): String = reference.present()
}