package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.type.JsString

class JsStringRef internal constructor(
    name: String? = null
) : JsString(), JsDeclarableReference<JsString> by JsValueRef(name) {
    override val name: String = name ?: "string_$id"
}

fun JsString.Companion.ref(name: String): JsStringRef = JsStringRef(name)