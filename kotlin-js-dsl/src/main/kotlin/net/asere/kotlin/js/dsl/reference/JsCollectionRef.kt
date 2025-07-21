package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.type.JsCollection
import net.asere.kotlin.js.dsl.value.JsValue

class JsCollectionRef<T : JsValue> internal constructor(
    name: String? = null
) : JsCollection<T>, JsDeclarableReference<T> by JsValueRef(
    name = name ?: "collection_${JsReference.nextRefInt()}"
) {
    override fun toString(): String = present()
}

fun <T : JsValue> JsCollection.Companion.ref(name: String? = null): JsCollectionRef<T> = JsCollectionRef(name)