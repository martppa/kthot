package net.asere.kotlin.js.dsl.dom.type.data.array

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsDomArrayRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsDomArray>(
    name ?: "dom_collection_object_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsDomArray, JsReference<JsDomArray> {
    override fun toString(): String = present()
}

fun JsDomArray.Companion.ref(name: String? = null, isNullable: Boolean = false): JsDomArrayRef =
    JsDomArrayRef(name, isNullable)

fun JsDomArray.Companion.def(name: String? = null, isNullable: Boolean = false) = object :
    JsPrintableDefinition<JsDomArrayRef, JsDomArray>() {
    override val reference: JsDomArrayRef = JsDomArrayRef(name, isNullable)
}