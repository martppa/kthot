package net.asere.kotlin.js.dsl.dom.reference.event

import net.asere.kotlin.js.dsl.dom.type.event.JsMouseEvent
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef

class JsMouseEventRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsMouseEvent>(
    name ?: "mouse_event_${JsReference.nextRefInt()}",
    isNullable = isNullable
), JsMouseEvent, JsReference<JsMouseEvent> {
    override fun toString(): String = present()
}

fun JsMouseEvent.Companion.ref(name: String? = null, isNullable: Boolean = false) = JsMouseEventRef(name, isNullable)

fun JsMouseEvent.Companion.def(name: String? = null) = object : JsPrintableDefinition<JsMouseEventRef, JsMouseEvent>() {
    override val reference: JsMouseEventRef = JsMouseEventRef(name)
}