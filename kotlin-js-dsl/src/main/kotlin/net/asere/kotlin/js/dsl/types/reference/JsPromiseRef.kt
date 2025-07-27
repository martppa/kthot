package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.type.JsPromise
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsPromiseRef<T : JsValue> internal constructor(
    name: String? = null
) : JsPromise<T>, JsReference<JsPromise<T>> by JsValueRef(
    name = name ?: "promise_${JsReference.nextRefInt()}"
) {
    override fun toString(): String = present()
}

fun <T : JsValue> JsPromise.Companion.ref(name: String? = null): JsPromise<T> = JsPromiseRef(name)

fun <T : JsValue> JsPromise.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsPromiseRef<T>, JsPromise<T>>() {
    override val reference: JsPromiseRef<T> = JsPromiseRef(name)
}