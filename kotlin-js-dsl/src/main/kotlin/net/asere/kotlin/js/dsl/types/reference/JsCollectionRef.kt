package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.type.JsBoolean
import net.asere.kotlin.js.dsl.types.type.JsCollection
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsCollectionRef<T : JsValue> internal constructor(
    name: String? = null
) : JsCollection<T>, JsReference<JsCollection<T>> by JsValueRef(
    name = name ?: "collection_${JsReference.nextRefInt()}"
) {
    override fun toString(): String = present()
}

fun <T : JsValue> JsCollection.Companion.ref(name: String? = null): JsCollectionRef<T> = JsCollectionRef(name)

fun <T : JsValue> JsCollection.Companion.def(name: String? = null) = object : JsDefinition<JsCollectionRef<T>, JsCollection<T>> {
    override val reference: JsCollectionRef<T> = JsCollectionRef(name)
}