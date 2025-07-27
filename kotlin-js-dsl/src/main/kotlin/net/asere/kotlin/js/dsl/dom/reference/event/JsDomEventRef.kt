package net.asere.kotlin.js.dsl.dom.reference.event

import net.asere.kotlin.js.dsl.dom.type.event.JsDomEvent
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef

class JsDomEventRef internal constructor(
    name: String? = null
) : JsValueRef<JsDomEvent>(
    name ?: "dom_event_${JsReference.nextRefInt()}"
), JsDomEvent, JsReference<JsDomEvent> {
    override fun toString(): String = present()
}

fun JsDomEvent.Companion.ref(name: String? = null) = JsDomEventRef(name)

fun JsDomEvent.Companion.def(name: String? = null) = object : JsPrintableDefinition<JsDomEventRef, JsDomEvent>() {
    override val reference: JsDomEventRef = JsDomEventRef(name)
}