package net.asere.kotlin.js.dsl.dom.reference.event

import net.asere.kotlin.js.dsl.dom.type.event.JsDomEvent
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef
import net.asere.kotlin.js.dsl.types.reference.ReferenceId

class JsDomEventRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsDomEvent>(
    name ?: "dom_event_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsDomEvent, JsReference<JsDomEvent> {
    override fun toString(): String = present()
}

fun JsDomEvent.Companion.ref(name: String? = null, isNullable: Boolean = false) = JsDomEventRef(name, isNullable)

fun JsDomEvent.Companion.def(name: String? = null, isNullable: Boolean = false) = object : JsPrintableDefinition<JsDomEventRef, JsDomEvent>() {
    override val reference: JsDomEventRef = JsDomEventRef(name, isNullable)
}