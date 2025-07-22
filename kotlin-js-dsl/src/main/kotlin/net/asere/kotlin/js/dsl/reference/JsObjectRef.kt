package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.type.JsObject

open class JsObjectRef internal constructor(
    name: String? = null
) : JsValueRef<JsObject>(name ?: "object_${JsReference.nextRefInt()}"), JsObject, JsDeclarableReference<JsObject> {
    override fun toString(): String = present()
}

fun JsObject.Companion.ref(name: String? = null) = JsObjectRef(name)