package net.asere.kthot.js.dsl.type.date

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsDateRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsDate>(
    name ?: "date_object_${ReferenceId.nextRefInt()}",
), JsDate, JsReference<JsDate> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDate.Companion.ref(name: String? = null): JsDateRef =
    JsDateRef(name)

@OptIn(JsInternalApi::class)
fun JsDate.Companion.ref(element: JsElement): JsDateRef =
    JsDateRef(element.present())

@OptIn(JsInternalApi::class)
fun JsDate.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsDateRef, JsDate>() {
    override val reference: JsDateRef = JsDateRef(name)
}