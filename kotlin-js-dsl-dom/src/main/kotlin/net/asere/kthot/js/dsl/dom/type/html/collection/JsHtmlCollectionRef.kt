package net.asere.kthot.js.dsl.dom.type.html.collection

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsHtmlCollectionRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsHtmlCollection>(
    name ?: "html_collection_object_${ReferenceId.nextRefInt()}",
), JsHtmlCollection, JsReference<JsHtmlCollection> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsHtmlCollection.Companion.ref(name: String? = null): JsHtmlCollectionRef =
    JsHtmlCollectionRef(name)

@OptIn(JsInternalApi::class)
fun JsHtmlCollection.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsHtmlCollectionRef, JsHtmlCollection>() {
    override val reference: JsHtmlCollectionRef = JsHtmlCollectionRef(name)
}