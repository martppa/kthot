package net.asere.kthot.js.dsl.dom.type.html.form.button

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsButtonElementRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsButtonElement>(
    name ?: "button_${ReferenceId.nextRefInt()}",
    
), JsButtonElement, JsReference<JsButtonElement> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsButtonElement.Companion.ref(name: String? = null): JsButtonElementRef =
    JsButtonElementRef(name)

@OptIn(JsInternalApi::class)
fun JsButtonElement.Companion.ref(element: JsElement): JsButtonElementRef =
    JsButtonElementRef(element.present())

@OptIn(JsInternalApi::class)
fun JsButtonElement.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsButtonElementRef, JsButtonElement>() {
        override val reference: JsButtonElementRef = JsButtonElementRef(name = name)
    }