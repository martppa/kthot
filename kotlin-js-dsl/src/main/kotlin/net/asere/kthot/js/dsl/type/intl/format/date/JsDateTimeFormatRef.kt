package net.asere.kthot.js.dsl.type.intl.format.date

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsDateTimeFormatRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsDateTimeFormat>(
    name ?: "date_time_format_object_${ReferenceId.nextRefInt()}",
), JsDateTimeFormat, JsReference<JsDateTimeFormat> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDateTimeFormat.Companion.ref(name: String? = null): JsDateTimeFormatRef =
    JsDateTimeFormatRef(name)

@OptIn(JsInternalApi::class)
fun JsDateTimeFormat.Companion.ref(element: JsElement): JsDateTimeFormatRef =
    JsDateTimeFormatRef(element.present())

@OptIn(JsInternalApi::class)
fun JsDateTimeFormat.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsDateTimeFormatRef, JsDateTimeFormat>() {
    override val reference: JsDateTimeFormatRef = JsDateTimeFormatRef(name)
}