package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsDomObject
import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.reference.JsValueRef
import net.asere.kotlin.js.dsl.value.JsValue

open class JsDomObjectRef(
    name: String? = null,
) : JsDomObject(), JsReference<JsValue> by JsValueRef(name) {

    override val name: String = name ?: "dom_object_$id"
}

