package net.asere.kthot.js.dsl.dom.type.html.element

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsHtmlElementRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsHtmlElement>(
    name ?: "html_element_object_${ReferenceId.nextRefInt()}",
), JsHtmlElement, JsReference<JsHtmlElement> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsHtmlElement.Companion.ref(name: String? = null): JsHtmlElementRef =
    JsHtmlElementRef(name)

@OptIn(JsInternalApi::class)
fun JsHtmlElement.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsHtmlElementRef, JsHtmlElement>() {
    override val reference: JsHtmlElementRef = JsHtmlElementRef(name)
}