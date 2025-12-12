package net.asere.kthot.js.dsl.dom.type.data.anchor

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsAnchorRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsAnchor>(
    name ?: "anchor_object_${ReferenceId.nextRefInt()}",
), JsAnchor, JsReference<JsAnchor> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsAnchor.Companion.ref(name: String? = null): JsAnchorRef =
    JsAnchorRef(name)

@OptIn(JsInternalApi::class)
fun JsAnchor.Companion.ref(element: JsElement): JsAnchorRef =
    JsAnchorRef(element.present())

@OptIn(JsInternalApi::class)
fun JsAnchor.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsAnchorRef, JsAnchor>() {
    override val reference: JsAnchorRef = JsAnchorRef(name)
}