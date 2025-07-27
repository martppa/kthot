package net.asere.kotlin.js.dsl.dom.reference.event

import net.asere.kotlin.js.dsl.dom.type.event.JsKeyboardEvent
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef
import net.asere.kotlin.js.dsl.types.reference.ReferenceId

class JsKeyboardEventRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsKeyboardEvent>(
    name ?: "keyboard_event_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsKeyboardEvent, JsReference<JsKeyboardEvent> {
    override fun toString(): String = present()
}

fun JsKeyboardEvent.Companion.ref(name: String? = null, isNullable: Boolean = false) = JsKeyboardEventRef(name, isNullable)

fun JsKeyboardEvent.Companion.def(name: String? = null, isNullable: Boolean = false) = object :
    JsPrintableDefinition<JsKeyboardEventRef, JsKeyboardEvent>() {
    override val reference: JsKeyboardEventRef = JsKeyboardEventRef(name, isNullable)
}