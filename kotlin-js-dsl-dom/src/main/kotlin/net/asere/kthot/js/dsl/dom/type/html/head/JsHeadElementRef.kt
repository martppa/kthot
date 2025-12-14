package net.asere.kthot.js.dsl.dom.type.html.head

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

@OptIn(JsInternalApi::class)
class JsHeadElementRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsHeadElement>(
    name ?: "head_element_object_${ReferenceId.nextRefInt()}",
), JsHeadElement, JsReference<JsHeadElement> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsHeadElement.Companion.ref(name: String? = null): JsHeadElementRef =
    JsHeadElementRef(name)

@OptIn(JsInternalApi::class)
fun JsHeadElement.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsHeadElementRef, JsHeadElement>() {
    override val reference: JsHeadElementRef = JsHeadElementRef(name)
}