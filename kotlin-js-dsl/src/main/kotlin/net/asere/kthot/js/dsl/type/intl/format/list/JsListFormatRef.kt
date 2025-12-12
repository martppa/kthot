package net.asere.kthot.js.dsl.type.intl.format.list

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsListFormatRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsListFormat>(
    name ?: "list_format_object_${ReferenceId.nextRefInt()}",
), JsListFormat, JsReference<JsListFormat> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsListFormat.Companion.ref(name: String? = null): JsListFormatRef =
    JsListFormatRef(name)

@OptIn(JsInternalApi::class)
fun JsListFormat.Companion.ref(element: JsElement): JsListFormatRef =
    JsListFormatRef(element.present())

@OptIn(JsInternalApi::class)
fun JsListFormat.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsListFormatRef, JsListFormat>() {
    override val reference: JsListFormatRef = JsListFormatRef(name)
}