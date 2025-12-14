package net.asere.kthot.js.dsl.dom.type.html.form

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsFormElementRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsFormElement>(
    name ?: "form_${ReferenceId.nextRefInt()}",
    
), JsFormElement, JsReference<JsFormElement> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsFormElement.Companion.ref(name: String? = null): JsFormElementRef =
    JsFormElementRef(name)

@OptIn(JsInternalApi::class)
fun JsFormElement.Companion.ref(element: JsElement): JsFormElementRef =
    JsFormElementRef(element.present())

@OptIn(JsInternalApi::class)
fun JsFormElement.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsFormElementRef, JsFormElement>() {
        override val reference: JsFormElementRef = JsFormElementRef(name = name)
    }