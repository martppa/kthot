package net.asere.kthot.js.dsl.type.intl.names

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsDisplayNamesRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsDisplayNames>(
    name ?: "display_names_object_${ReferenceId.nextRefInt()}",
), JsDisplayNames, JsReference<JsDisplayNames> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDisplayNames.Companion.ref(name: String? = null): JsDisplayNamesRef =
    JsDisplayNamesRef(name)

@OptIn(JsInternalApi::class)
fun JsDisplayNames.Companion.ref(element: JsElement): JsDisplayNamesRef =
    JsDisplayNamesRef(element.present())

@OptIn(JsInternalApi::class)
fun JsDisplayNames.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsDisplayNamesRef, JsDisplayNames>() {
    override val reference: JsDisplayNamesRef = JsDisplayNamesRef(name)
}