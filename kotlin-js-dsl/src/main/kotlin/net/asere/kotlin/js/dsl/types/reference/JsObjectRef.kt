package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.type.JsObject

open class JsObjectRef internal constructor(
    name: String? = null
) : JsValueRef<JsObject>(name ?: "object_${JsReference.nextRefInt()}"), JsObject, JsReference<JsObject> {
    override fun toString(): String = present()
}

fun JsObject.Companion.ref(name: String? = null) = JsObjectRef(name)

fun JsObject.Companion.def(name: String? = null) = object : JsDefinition<JsObjectRef, JsObject> {
    override val reference: JsObjectRef = JsObjectRef(name)
}