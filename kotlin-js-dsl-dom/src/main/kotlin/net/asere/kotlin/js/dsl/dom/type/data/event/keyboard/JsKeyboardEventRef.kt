package net.asere.kotlin.js.dsl.dom.type.data.event.keyboard

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsKeyboardEventRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsKeyboardEvent>(
    name ?: "keyboard_event_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsKeyboardEvent, JsReference<JsKeyboardEvent> {
    override fun toString(): String = present()
}

fun JsKeyboardEvent.Companion.ref(name: String? = null, isNullable: Boolean = false): JsKeyboardEventRef =
    JsKeyboardEventRef(name, isNullable)

fun JsKeyboardEvent.Companion.def(name: String? = null, isNullable: Boolean = false) = object :
    JsPrintableDefinition<JsKeyboardEventRef, JsKeyboardEvent>() {
    override val reference: JsKeyboardEventRef = JsKeyboardEventRef(name, isNullable)
}