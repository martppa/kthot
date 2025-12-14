package net.asere.kthot.js.dsl.dom.type.html.anchor

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsAnchorElementRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsAnchorElement>(
    name ?: "anchor_object_${ReferenceId.nextRefInt()}",
), JsAnchorElement, JsReference<JsAnchorElement> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsAnchorElement.Companion.ref(name: String? = null): JsAnchorElementRef =
    JsAnchorElementRef(name)

@OptIn(JsInternalApi::class)
fun JsAnchorElement.Companion.ref(element: JsElement): JsAnchorElementRef =
    JsAnchorElementRef(element.present())

@OptIn(JsInternalApi::class)
fun JsAnchorElement.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsAnchorElementRef, JsAnchorElement>() {
    override val reference: JsAnchorElementRef = JsAnchorElementRef(name)
}