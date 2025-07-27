package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsDomArray
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef

class JsDomArrayRef internal constructor(
    name: String? = null
) : JsValueRef<JsDomArray>(
name ?: "dom_collection_object_${JsReference.nextRefInt()}"
), JsDomArray, JsReference<JsDomArray> {
    override fun toString(): String = present()
}

fun JsDomArray.Companion.ref(name: String? = null) = JsDomArrayRef(name)

fun JsDomArray.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsDomArrayRef, JsDomArray>() {
    override val reference: JsDomArrayRef = JsDomArrayRef(name)
}