package net.asere.kthot.js.dsl.type.lambda

import net.asere.kthot.js.dsl.type.JsCallable
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.value.JsValue

abstract class JsLambdaRef<T : JsValue>(
    name: String,
) : JsValueRef<T>(name), JsCallable {
    override fun toString(): String = present()
}