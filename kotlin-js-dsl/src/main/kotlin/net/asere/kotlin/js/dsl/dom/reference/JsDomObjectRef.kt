package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsDomObject
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef

open class JsDomObjectRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsDomObject>(
    name ?: "dom_object_${JsReference.nextRefInt()}",
    isNullable = isNullable,
), JsDomObject, JsReference<JsDomObject> {
    override fun toString(): String = present()
}

fun JsDomObject.Companion.ref(name: String? = null, isNullable: Boolean = false) = JsDomObjectRef(name, isNullable)

fun JsDomObject.Companion.def(name: String? = null) = object : JsPrintableDefinition<JsDomObjectRef, JsDomObject>() {
    override val reference: JsDomObjectRef = JsDomObjectRef(name = name)
}