package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.type.JsObject

open class JsObjectRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsObject>(
    name = name ?: "object_${ReferenceId.nextRefInt()}",
    isNullable = isNullable
), JsObject {
    override fun toString(): String = present()
}

fun JsObject.Companion.ref(name: String? = null, isNullable: Boolean = false) = JsObjectRef(name, isNullable)

fun JsObject.Companion.def(name: String? = null) = object : JsPrintableDefinition<JsObjectRef, JsObject>() {
    override val reference: JsObjectRef = JsObjectRef(name)
}