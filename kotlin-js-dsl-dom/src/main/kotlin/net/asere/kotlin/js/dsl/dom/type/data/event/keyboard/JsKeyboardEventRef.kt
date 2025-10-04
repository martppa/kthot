package net.asere.kotlin.js.dsl.dom.type.data.event.keyboard

import net.asere.kotlin.js.dsl.annotation.JsInternalApi
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsKeyboardEventRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsKeyboardEvent>(
    name ?: "keyboard_event_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsKeyboardEvent, JsReference<JsKeyboardEvent> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsKeyboardEvent.Companion.ref(element: JsElement, isNullable: Boolean = false): JsKeyboardEventRef =
    JsKeyboardEventRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsKeyboardEvent.Companion.def(name: String? = null, isNullable: Boolean = false) = object :
    JsPrintableDefinition<JsKeyboardEventRef, JsKeyboardEvent>() {
    override val reference: JsKeyboardEventRef = JsKeyboardEventRef(name, isNullable)
}