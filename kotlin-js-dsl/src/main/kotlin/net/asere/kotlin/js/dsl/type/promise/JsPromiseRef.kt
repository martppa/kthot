package net.asere.kotlin.js.dsl.type.promise

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsPromiseRef<T : JsValue> @InternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsPromise<T>, JsValueRef<JsPromise<T>>(
    name = name ?: "promise_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

@OptIn(InternalApi::class)
fun <T : JsValue> JsPromise.Companion.ref(name: String? = null, isNullable: Boolean = false): JsPromise<T> =
    JsPromiseRef(name, isNullable)

@OptIn(InternalApi::class)
fun <T : JsValue> JsPromise.Companion.ref(element: JsElement, isNullable: Boolean = false): JsPromise<T> =
    JsPromiseRef(element.present(), isNullable)

@OptIn(InternalApi::class)
fun <T : JsValue> JsPromise.Companion.def(name: String? = null, isNullable: Boolean = false) = object :
    JsPrintableDefinition<JsPromiseRef<T>, JsPromise<T>>() {
    override val reference: JsPromiseRef<T> = JsPromiseRef(name, isNullable)
}