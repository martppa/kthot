package net.asere.kthot.js.dsl.dom.type.core.event.target

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

open class JsEventTargetRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsEventTarget>(
    name ?: "event_target_object_${ReferenceId.nextRefInt()}",
), JsEventTarget, JsReference<JsEventTarget> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsEventTarget.Companion.ref(name: String? = null): JsEventTargetRef =
    JsEventTargetRef(name)

@OptIn(JsInternalApi::class)
fun JsEventTarget.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsEventTargetRef, JsEventTarget>() {
    override val reference: JsEventTargetRef = JsEventTargetRef(name)
}