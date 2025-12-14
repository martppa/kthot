package net.asere.kthot.js.dsl.dom.type.html.div

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsDivElementRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsDivElement>(
    name ?: "div_${ReferenceId.nextRefInt()}",
), JsDivElement, JsReference<JsDivElement> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDivElement.Companion.ref(name: String? = null): JsDivElementRef =
    JsDivElementRef(name)

@OptIn(JsInternalApi::class)
fun JsDivElement.Companion.ref(element: JsElement): JsDivElementRef =
    JsDivElementRef(element.present())

@OptIn(JsInternalApi::class)
fun JsDivElement.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsDivElementRef, JsDivElement>() {
        override val reference: JsDivElementRef = JsDivElementRef(name = name)
    }