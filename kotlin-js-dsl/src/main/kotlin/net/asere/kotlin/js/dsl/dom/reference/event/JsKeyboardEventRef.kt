package net.asere.kotlin.js.dsl.dom.reference.event

import net.asere.kotlin.js.dsl.dom.type.event.JsKeyboardEvent
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef

class JsKeyboardEventRef internal constructor(
    name: String? = null
) : JsValueRef<JsKeyboardEvent>(
    name ?: "keyboard_event_${JsReference.nextRefInt()}"
), JsKeyboardEvent, JsReference<JsKeyboardEvent> {
    override fun toString(): String = present()
}

fun JsKeyboardEvent.Companion.ref(name: String? = null) = JsKeyboardEventRef(name)

fun JsKeyboardEvent.Companion.def(name: String? = null) = object : JsDefinition<JsKeyboardEventRef, JsKeyboardEvent> {
    override val reference: JsKeyboardEventRef = JsKeyboardEventRef(name)
}