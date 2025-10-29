@file:OptIn(JsInternalApi::class)

package net.asere.kthot.js.dsl.type.promise

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

class JsPromiseRef<T : JsValue> @JsInternalApi constructor(
    name: String? = null,
    override val typeBuilder: (JsElement) -> T
) : JsPromise<T>, JsValueRef<JsPromise<T>>(
    name = name ?: "promise_${ReferenceId.nextRefInt()}",
) {
    override fun toString(): String = present()
}

fun <T : JsValue> JsPromise.Companion.ref(
    name: String? = null,
    typeBuilder: (JsElement) -> T
): JsPromise<T> = JsPromiseRef(
    name = name,
    typeBuilder = typeBuilder
)

inline fun <reified T : JsValue> JsPromise.Companion.ref(
    name: String? = null,
): JsPromise<T> = JsPromiseRef(
    name = name,
    typeBuilder = ::provide
)

fun <T : JsValue> JsPromise.Companion.ref(
    element: JsElement,
    typeBuilder: (JsElement) -> T
): JsPromise<T> = JsPromiseRef(
    name = "$element",
    typeBuilder = typeBuilder
)

inline fun <reified T : JsValue> JsPromise.Companion.ref(
    element: JsElement,
): JsPromise<T> = JsPromiseRef(
    name = "$element",
    typeBuilder = ::provide
)


fun <T : JsValue> JsPromise.Companion.def(
    name: String? = null,
    typeBuilder: (JsElement) -> T
) = object : JsPrintableDefinition<JsPromiseRef<T>, JsPromise<T>>() {
    override val reference: JsPromiseRef<T> = JsPromiseRef(
        name = name,
        typeBuilder = typeBuilder
    )
}

inline fun <reified T : JsValue> JsPromise.Companion.def(
    name: String? = null,
) = object : JsPrintableDefinition<JsPromiseRef<T>, JsPromise<T>>() {
    override val reference: JsPromiseRef<T> = JsPromiseRef(
        name = name,
        typeBuilder = ::provide
    )
}