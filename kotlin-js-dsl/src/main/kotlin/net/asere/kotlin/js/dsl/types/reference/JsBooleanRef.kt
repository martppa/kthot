package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.type.JsBoolean

class JsBooleanRef(
    name: String? = null
) : JsBoolean, JsReference<JsBoolean> by JsValueRef(
    name = name ?: "boolean_${JsReference.nextRefInt()}"
) {
    override fun toString(): String = present()
}

fun JsBoolean.Companion.ref(name: String? = null) = JsBooleanRef(name)

fun JsBoolean.Companion.def(name: String? = null) = object : JsDefinition<JsBooleanRef, JsBoolean> {
    override val reference: JsBooleanRef = JsBooleanRef(name)
}