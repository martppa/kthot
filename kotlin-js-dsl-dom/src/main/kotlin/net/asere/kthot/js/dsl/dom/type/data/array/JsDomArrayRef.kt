package net.asere.kthot.js.dsl.dom.type.data.array

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsDomArrayRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsDomArray>(
    name ?: "dom_collection_object_${ReferenceId.nextRefInt()}",
    
), JsDomArray, JsReference<JsDomArray> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDomArray.Companion.ref(name: String? = null): JsDomArrayRef =
    JsDomArrayRef(name)

@OptIn(JsInternalApi::class)
fun JsDomArray.Companion.ref(element: JsElement): JsDomArrayRef =
    JsDomArrayRef(element.present())

@OptIn(JsInternalApi::class)
fun JsDomArray.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsDomArrayRef, JsDomArray>() {
    override val reference: JsDomArrayRef = JsDomArrayRef(name)
}