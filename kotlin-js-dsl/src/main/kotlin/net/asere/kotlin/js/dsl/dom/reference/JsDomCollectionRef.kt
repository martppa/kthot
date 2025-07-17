package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsDomCollection
import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.reference.JsValueRef
import net.asere.kotlin.js.dsl.value.JsValue

class JsDomCollectionRef(
    name: String? = null
) : JsDomCollection(), JsReference<JsValue> by JsValueRef(
    name = name ?: "dom_collection_${JsReference.nextRefInt()}"
)