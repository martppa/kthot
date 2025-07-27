package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsDomObject
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef
import net.asere.kotlin.js.dsl.types.type.JsString

open class JsDomObjectRef internal constructor(
    name: String? = null,
) : JsValueRef<JsDomObject>(
    name ?: "dom_object_${JsReference.nextRefInt()}"
), JsDomObject, JsReference<JsDomObject> {
    override fun toString(): String = present()
}

fun JsDomObject.Companion.ref(name: String? = null) = JsDomObjectRef(name)

fun JsDomObject.Companion.def(name: String? = null) = object : JsPrintableDefinition<JsDomObjectRef, JsDomObject>() {
    override val reference: JsDomObjectRef = JsDomObjectRef(name)
}