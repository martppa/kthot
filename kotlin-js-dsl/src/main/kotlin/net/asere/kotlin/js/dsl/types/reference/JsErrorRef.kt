package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.type.JsError

class JsErrorRef internal constructor(
    name: String? = null
) : JsError, JsReference<JsError> by JsValueRef(
    name = name ?: "error_${JsReference.nextRefInt()}"
) {
    override fun toString(): String = present()
}

fun JsError.Companion.ref(name: String? = null): JsError = JsErrorRef(name)

fun JsError.Companion.def(name: String? = null) = object : JsPrintableDefinition<JsErrorRef, JsError>() {
    override val reference: JsErrorRef = JsErrorRef(name)
}