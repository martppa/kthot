package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.type.JsString

class JsStringRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsString, JsReference<JsString> by JsValueRef(
    name = name ?: "string_${JsReference.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

fun JsString.Companion.ref(name: String? = null, isNullable: Boolean = false): JsStringRef = JsStringRef(name, isNullable)

fun JsString.Companion.def(name: String? = null) = object : JsPrintableDefinition<JsStringRef, JsString>() {
    override val reference: JsStringRef = JsStringRef(name)
}