package net.asere.kthot.js.dsl.type.intl.segmenter

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsSegmenterRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsSegmenter>(
    name ?: "segmenter_object_${ReferenceId.nextRefInt()}",
), JsSegmenter, JsReference<JsSegmenter> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsSegmenter.Companion.ref(name: String? = null): JsSegmenterRef =
    JsSegmenterRef(name)

@OptIn(JsInternalApi::class)
fun JsSegmenter.Companion.ref(element: JsElement): JsSegmenterRef =
    JsSegmenterRef(element.present())

@OptIn(JsInternalApi::class)
fun JsSegmenter.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsSegmenterRef, JsSegmenter>() {
    override val reference: JsSegmenterRef = JsSegmenterRef(name)
}