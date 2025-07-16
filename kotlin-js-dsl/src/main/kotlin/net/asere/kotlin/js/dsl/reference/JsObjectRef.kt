package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.type.JsObject

open class JsObjectRef internal constructor(
    name: String? = null
) : JsObject(), JsDeclarableReference<JsNumber> by JsValueRef(name) {
    override val name: String by lazy { name ?: "object_$id" }
}

fun JsObject.Companion.ref(name: String? = null) = JsObjectRef(name)