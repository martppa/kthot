package net.asere.kotlin.js.dsl.dom.type.data.obj

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

open class JsDomObjectRef @InternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsDomObject>(
    name ?: "dom_object_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsDomObject, JsReference<JsDomObject> {
    override fun toString(): String = present()
}

@OptIn(InternalApi::class)
fun JsDomObject.Companion.ref(name: String? = null, isNullable: Boolean = false): JsDomObjectRef =
    JsDomObjectRef(name, isNullable)

@OptIn(InternalApi::class)
fun JsDomObject.Companion.ref(element: JsElement, isNullable: Boolean = false): JsDomObjectRef =
    JsDomObjectRef(element.present(), isNullable)

@OptIn(InternalApi::class)
fun JsDomObject.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsDomObjectRef, JsDomObject>() {
        override val reference: JsDomObjectRef = JsDomObjectRef(name = name, isNullable)
    }