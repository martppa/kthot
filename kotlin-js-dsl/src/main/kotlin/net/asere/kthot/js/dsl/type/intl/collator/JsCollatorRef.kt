package net.asere.kthot.js.dsl.type.intl.collator

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsCollatorRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsCollator>(
    name ?: "collator_object_${ReferenceId.nextRefInt()}",
), JsCollator, JsReference<JsCollator> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsCollator.Companion.ref(name: String? = null): JsCollatorRef =
    JsCollatorRef(name)

@OptIn(JsInternalApi::class)
fun JsCollator.Companion.ref(element: JsElement): JsCollatorRef =
    JsCollatorRef(element.present())

@OptIn(JsInternalApi::class)
fun JsCollator.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsCollatorRef, JsCollator>() {
    override val reference: JsCollatorRef = JsCollatorRef(name)
}