package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.type.JsNumber

class JsNumberRef internal constructor(
    name: String? = null
) : JsNumber(), JsDeclarableReference<JsNumber> by JsValueRef(name) {
    override val name: String = name ?: "number_$id"
}

fun JsNumber.Companion.ref(name: String? = null) = JsNumberRef(name)