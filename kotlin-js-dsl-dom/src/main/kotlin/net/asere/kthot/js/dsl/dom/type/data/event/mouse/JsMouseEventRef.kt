package net.asere.kthot.js.dsl.dom.type.data.event.mouse

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsMouseEventRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsMouseEvent>(
    name ?: "mouse_event_${ReferenceId.nextRefInt()}",
    
), JsMouseEvent, JsReference<JsMouseEvent> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsMouseEvent.Companion.ref(name: String? = null): JsMouseEventRef =
    JsMouseEventRef(name)

@OptIn(JsInternalApi::class)
fun JsMouseEvent.Companion.ref(element: JsElement): JsMouseEventRef =
    JsMouseEventRef(element.present())

@OptIn(JsInternalApi::class)
fun JsMouseEvent.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsMouseEventRef, JsMouseEvent>() {
        override val reference: JsMouseEventRef = JsMouseEventRef(name)
    }