package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.type.JsCollection
import net.asere.kotlin.js.dsl.value.JsValue

class JsCollectionRef<T : JsValue> internal constructor(
    name: String? = null
) : JsCollection<T>(), JsDeclarableReference<T> by JsValueRef(name) {

    override val name: String = name ?: "collection_$id"
}

fun <T : JsValue> JsCollection.Companion.ref(name: String? = null): JsCollectionRef<JsReference<T>> = JsCollectionRef(name)