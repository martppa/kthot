package net.asere.kthot.js.dsl.type.lambda

import net.asere.kthot.js.dsl.type.JsCallable
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.value.JsValue

abstract class JsLambdaRef<T : JsValue>(
    name: String,
    isNullable: Boolean = false
) : JsValueRef<T>(name, isNullable), JsCallable {
    override fun toString(): String = present()
}