package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsDomObject
import net.asere.kotlin.js.dsl.reference.JsDeclarableReference
import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.JsObject
import net.asere.kotlin.js.dsl.value.JsValue

open class JsDomObjectRef internal constructor(
    name: String? = null,
) : JsValueRef<JsDomObject>(
    name ?: "dom_object_${JsReference.nextRefInt()}"
), JsDomObject, JsDeclarableReference<JsDomObject> {
    override fun toString(): String = present()
}