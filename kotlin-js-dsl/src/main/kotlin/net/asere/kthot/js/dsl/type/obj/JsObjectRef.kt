package net.asere.kthot.js.dsl.type.obj

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

open class JsObjectRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsObject>(
    name = name ?: "object_${ReferenceId.nextRefInt()}",
    isNullable = isNullable
), JsObject {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsObject.Companion.ref(name: String? = null, isNullable: Boolean = false): JsObjectRef =
    JsObjectRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsObject.Companion.ref(element: JsElement, isNullable: Boolean = false): JsObjectRef =
    JsObjectRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsObject.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsObjectRef, JsObject>() {
        override val reference: JsObjectRef = JsObjectRef(name, isNullable)
    }