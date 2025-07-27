package net.asere.kotlin.js.dsl.types.definition

import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.value.JsValue

abstract class JsPrintableDefinition<T : JsReference<C>, C : JsValue> : JsDefinition<T, C> {
    override fun toString(): String = reference.present()
}