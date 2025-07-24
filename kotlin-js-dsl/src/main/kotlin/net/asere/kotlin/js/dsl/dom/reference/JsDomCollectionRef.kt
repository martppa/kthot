package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsDomCollection
import net.asere.kotlin.js.dsl.reference.JsDeclarableReference
import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.reference.JsValueRef

class JsDomCollectionRef internal constructor(
    name: String? = null
) : JsValueRef<JsDomCollection>(
name ?: "dom_collection_object_${JsReference.nextRefInt()}"
), JsDomCollection, JsDeclarableReference<JsDomCollection> {
    override fun toString(): String = present()
}