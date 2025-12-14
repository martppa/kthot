package net.asere.kthot.js.dsl.dom.type.html.form.validity

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsValidityStateRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsValidityState>(
    name ?: "validitystate_${ReferenceId.nextRefInt()}",
    
), JsValidityState, JsReference<JsValidityState> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsValidityState.Companion.ref(name: String? = null): JsValidityStateRef =
    JsValidityStateRef(name)

@OptIn(JsInternalApi::class)
fun JsValidityState.Companion.ref(element: JsElement): JsValidityStateRef =
    JsValidityStateRef(element.present())

@OptIn(JsInternalApi::class)
fun JsValidityState.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsValidityStateRef, JsValidityState>() {
        override val reference: JsValidityStateRef = JsValidityStateRef(name = name)
    }