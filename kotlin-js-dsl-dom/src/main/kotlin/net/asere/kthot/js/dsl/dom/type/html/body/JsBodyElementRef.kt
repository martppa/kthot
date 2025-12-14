package net.asere.kthot.js.dsl.dom.type.html.body

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

@OptIn(JsInternalApi::class)
class JsBodyElementRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsBodyElement>(
    name ?: "body_element_object_${ReferenceId.nextRefInt()}",
), JsBodyElement, JsReference<JsBodyElement> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsBodyElement.Companion.ref(name: String? = null): JsBodyElementRef =
    JsBodyElementRef(name)

@OptIn(JsInternalApi::class)
fun JsBodyElement.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsBodyElementRef, JsBodyElement>() {
    override val reference: JsBodyElementRef = JsBodyElementRef(name)
}