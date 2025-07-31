package net.asere.kotlin.js.dsl.dom.type.event.mouse

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsMouseEventRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsMouseEvent>(
    name ?: "mouse_event_${ReferenceId.nextRefInt()}",
    isNullable = isNullable
), JsMouseEvent, JsReference<JsMouseEvent> {
    override fun toString(): String = present()
}

fun JsMouseEvent.Companion.ref(name: String? = null, isNullable: Boolean = false): JsMouseEventRef =
    JsMouseEventRef(name, isNullable)

fun JsMouseEvent.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsMouseEventRef, JsMouseEvent>() {
        override val reference: JsMouseEventRef = JsMouseEventRef(name, isNullable)
    }