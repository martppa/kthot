package net.asere.kthot.js.dsl.dom.type.data.event.dom

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsDomEventRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsDomEvent>(
    name ?: "dom_event_${ReferenceId.nextRefInt()}",
    
), JsDomEvent, JsReference<JsDomEvent> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDomEvent.Companion.ref(name: String? = null): JsDomEventRef =
    JsDomEventRef(name)

@OptIn(JsInternalApi::class)
fun JsDomEvent.Companion.ref(element: JsElement): JsDomEventRef =
    JsDomEventRef(element.present())

@OptIn(JsInternalApi::class)
fun JsDomEvent.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsDomEventRef, JsDomEvent>() {
        override val reference: JsDomEventRef = JsDomEventRef(name)
    }