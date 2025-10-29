package net.asere.kthot.js.dsl.dom.type.data.event.keyboard

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsKeyboardEventRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsKeyboardEvent>(
    name ?: "keyboard_event_${ReferenceId.nextRefInt()}",
    
), JsKeyboardEvent, JsReference<JsKeyboardEvent> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsKeyboardEvent.Companion.ref(element: JsElement): JsKeyboardEventRef =
    JsKeyboardEventRef(element.present())

@OptIn(JsInternalApi::class)
fun JsKeyboardEvent.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsKeyboardEventRef, JsKeyboardEvent>() {
    override val reference: JsKeyboardEventRef = JsKeyboardEventRef(name)
}