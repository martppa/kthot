package net.asere.kthot.js.dsl.dom.type.core.element

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsDomElementRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsDomElement>(
    name ?: "dom_element_object_${ReferenceId.nextRefInt()}",
), JsDomElement, JsReference<JsDomElement> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDomElement.Companion.ref(name: String? = null): JsDomElementRef =
    JsDomElementRef(name)

@OptIn(JsInternalApi::class)
fun JsDomElement.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsDomElementRef, JsDomElement>() {
    override val reference: JsDomElementRef = JsDomElementRef(name)
}