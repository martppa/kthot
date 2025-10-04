@file:OptIn(JsInternalApi::class)

package net.asere.kotlin.js.dsl.type.promise

import net.asere.kotlin.js.dsl.annotation.JsInternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsPromiseRef<T : JsValue> @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
    override val typeBuilder: (JsElement, Boolean) -> T
) : JsPromise<T>, JsValueRef<JsPromise<T>>(
    name = name ?: "promise_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

fun <T : JsValue> JsPromise.Companion.ref(
    name: String? = null,
    isNullable: Boolean = false,
    typeBuilder: (JsElement, Boolean) -> T
): JsPromise<T> = JsPromiseRef(
    name = name,
    isNullable = isNullable,
    typeBuilder = typeBuilder
)

inline fun <reified T : JsValue> JsPromise.Companion.ref(
    name: String? = null,
    isNullable: Boolean = false
): JsPromise<T> = JsPromiseRef(
    name = name,
    isNullable = isNullable,
    typeBuilder = ::provide
)

fun <T : JsValue> JsPromise.Companion.ref(
    element: JsElement,
    isNullable: Boolean = false,
    typeBuilder: (JsElement, Boolean) -> T
): JsPromise<T> = JsPromiseRef(
    name = "$element",
    isNullable = isNullable,
    typeBuilder = typeBuilder
)

inline fun <reified T : JsValue> JsPromise.Companion.ref(
    element: JsElement,
    isNullable: Boolean = false,
): JsPromise<T> = JsPromiseRef(
    name = "$element",
    isNullable = isNullable,
    typeBuilder = ::provide
)


fun <T : JsValue> JsPromise.Companion.def(
    name: String? = null,
    isNullable: Boolean = false,
    typeBuilder: (JsElement, Boolean) -> T
) = object : JsPrintableDefinition<JsPromiseRef<T>, JsPromise<T>>() {
    override val reference: JsPromiseRef<T> = JsPromiseRef(
        name = name,
        isNullable = isNullable,
        typeBuilder = typeBuilder
    )
}

inline fun <reified T : JsValue> JsPromise.Companion.def(
    name: String? = null,
    isNullable: Boolean = false
) = object : JsPrintableDefinition<JsPromiseRef<T>, JsPromise<T>>() {
    override val reference: JsPromiseRef<T> = JsPromiseRef(
        name = name,
        isNullable = isNullable,
        typeBuilder = ::provide
    )
}