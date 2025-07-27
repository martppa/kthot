package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsDomCollection
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef

class JsDomCollectionRef internal constructor(
    name: String? = null
) : JsValueRef<JsDomCollection>(
name ?: "dom_collection_object_${JsReference.nextRefInt()}"
), JsDomCollection, JsReference<JsDomCollection> {
    override fun toString(): String = present()
}

fun JsDomCollection.Companion.ref(name: String? = null) = JsDomCollectionRef(name)

fun JsDomCollection.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsDomCollectionRef, JsDomCollection>() {
    override val reference: JsDomCollectionRef = JsDomCollectionRef(name)
}