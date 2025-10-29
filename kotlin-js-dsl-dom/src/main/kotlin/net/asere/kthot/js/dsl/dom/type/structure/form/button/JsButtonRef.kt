package net.asere.kthot.js.dsl.dom.type.structure.form.button

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsButtonRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsButton>(
    name ?: "button_${ReferenceId.nextRefInt()}",
    
), JsButton, JsReference<JsButton> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsButton.Companion.ref(name: String? = null): JsButtonRef =
    JsButtonRef(name)

@OptIn(JsInternalApi::class)
fun JsButton.Companion.ref(element: JsElement): JsButtonRef =
    JsButtonRef(element.present())

@OptIn(JsInternalApi::class)
fun JsButton.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsButtonRef, JsButton>() {
        override val reference: JsButtonRef = JsButtonRef(name = name)
    }