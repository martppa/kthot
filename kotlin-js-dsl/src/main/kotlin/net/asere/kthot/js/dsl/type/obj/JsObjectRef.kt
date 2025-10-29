package net.asere.kthot.js.dsl.type.obj

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

open class JsObjectRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsObject>(
    name = name ?: "object_${ReferenceId.nextRefInt()}",
), JsObject {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsObject.Companion.ref(name: String? = null): JsObjectRef =
    JsObjectRef(name)

@OptIn(JsInternalApi::class)
fun JsObject.Companion.ref(element: JsElement ): JsObjectRef =
    JsObjectRef(element.present())

@OptIn(JsInternalApi::class)
fun JsObject.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsObjectRef, JsObject>() {
        override val reference: JsObjectRef = JsObjectRef(name)
    }