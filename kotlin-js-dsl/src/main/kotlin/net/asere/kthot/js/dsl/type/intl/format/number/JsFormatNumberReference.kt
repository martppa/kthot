package net.asere.kthot.js.dsl.type.intl.format.number

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsNumberFormatRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsNumberFormat>(
    name ?: "number_format_object_${ReferenceId.nextRefInt()}",
), JsNumberFormat, JsReference<JsNumberFormat> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsNumberFormat.Companion.ref(name: String? = null): JsNumberFormatRef =
    JsNumberFormatRef(name)

@OptIn(JsInternalApi::class)
fun JsNumberFormat.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsNumberFormatRef, JsNumberFormat>() {
    override val reference: JsNumberFormatRef = JsNumberFormatRef(name)
}