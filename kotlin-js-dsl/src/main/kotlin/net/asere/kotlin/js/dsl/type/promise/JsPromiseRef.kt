package net.asere.kotlin.js.dsl.type.promise

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

@OptIn(InternalApi::class)
class JsPromiseRef<T : JsValue> @InternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
    override val typeBuilder: (JsElement, Boolean) -> T
) : JsPromise<T>, JsValueRef<JsPromise<T>>(
    name = name ?: "promise_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

@OptIn(InternalApi::class)
inline fun <reified T : JsValue> JsPromise.Companion.ref(
    name: String? = null,
    isNullable: Boolean = false,
    noinline typeBuilder: (JsElement, Boolean) -> T = ::provide
): JsPromise<T> = JsPromiseRef(
    name = name,
    isNullable = isNullable,
    typeBuilder = typeBuilder
)

@OptIn(InternalApi::class)
inline fun <reified T : JsValue> JsPromise.Companion.def(
    name: String? = null,
    isNullable: Boolean = false,
    noinline typeBuilder: (JsElement, Boolean) -> T = ::provide
) = object :
    JsPrintableDefinition<JsPromiseRef<T>, JsPromise<T>>() {
    override val reference: JsPromiseRef<T> = JsPromiseRef(
        name = name,
        isNullable = isNullable,
        typeBuilder = typeBuilder,
    )
}