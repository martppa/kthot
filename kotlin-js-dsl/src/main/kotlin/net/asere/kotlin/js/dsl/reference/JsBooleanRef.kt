package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.type.JsBoolean

class JsBooleanRef(
    name: String? = null
) : JsBoolean, JsDeclarableReference<JsBoolean> by JsValueRef(
    name = name ?: "boolean_${JsReference.nextRefInt()}"
) {
    override fun toString(): String = present()
}

fun JsBoolean.Companion.ref(name: String? = null) = JsBooleanRef(name)