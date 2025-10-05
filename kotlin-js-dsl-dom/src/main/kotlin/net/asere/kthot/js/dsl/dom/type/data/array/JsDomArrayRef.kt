package net.asere.kthot.js.dsl.dom.type.data.array

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsDomArrayRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsDomArray>(
    name ?: "dom_collection_object_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsDomArray, JsReference<JsDomArray> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDomArray.Companion.ref(name: String? = null, isNullable: Boolean = false): JsDomArrayRef =
    JsDomArrayRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsDomArray.Companion.ref(element: JsElement, isNullable: Boolean = false): JsDomArrayRef =
    JsDomArrayRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsDomArray.Companion.def(name: String? = null, isNullable: Boolean = false) = object :
    JsPrintableDefinition<JsDomArrayRef, JsDomArray>() {
    override val reference: JsDomArrayRef = JsDomArrayRef(name, isNullable)
}