package net.asere.kthot.js.dsl.dom.type.data.obj

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

open class JsDomObjectRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsDomObject>(
    name ?: "dom_object_${ReferenceId.nextRefInt()}",
    
), JsDomObject, JsReference<JsDomObject> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDomObject.Companion.ref(name: String? = null): JsDomObjectRef =
    JsDomObjectRef(name)

@OptIn(JsInternalApi::class)
fun JsDomObject.Companion.ref(element: JsElement): JsDomObjectRef =
    JsDomObjectRef(element.present())

@OptIn(JsInternalApi::class)
fun JsDomObject.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsDomObjectRef, JsDomObject>() {
        override val reference: JsDomObjectRef = JsDomObjectRef(name = name)
    }