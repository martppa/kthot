package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.type.JsString

class JsStringRef internal constructor(
    name: String? = null
) : JsString, JsDeclarableReference<JsString> by JsValueRef(
    name = name ?: "string_${JsReference.nextRefInt()}"
) {
    override fun toString(): String = present()
}

fun JsString.Companion.ref(name: String? = null): JsStringRef = JsStringRef(name)