package net.asere.kthot.js.dsl.type.intl.format.time

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsRelativeTimeFormatRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsRelativeTimeFormat>(
    name ?: "relative_time_format_object_${ReferenceId.nextRefInt()}",
), JsRelativeTimeFormat, JsReference<JsRelativeTimeFormat> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsRelativeTimeFormat.Companion.ref(name: String? = null): JsRelativeTimeFormatRef =
    JsRelativeTimeFormatRef(name)

@OptIn(JsInternalApi::class)
fun JsRelativeTimeFormat.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsRelativeTimeFormatRef, JsRelativeTimeFormat>() {
    override val reference: JsRelativeTimeFormatRef = JsRelativeTimeFormatRef(name)
}