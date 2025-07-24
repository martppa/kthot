package net.asere.kotlin.js.dsl.types.reference.lambda

import net.asere.kotlin.js.dsl.types.reference.JsValueRef
import net.asere.kotlin.js.dsl.types.value.JsValue

abstract class JsLambdaRefCommons<T : JsValue>(
    name: String
) : JsValueRef<T>(name) {
    override fun toString(): String = present()
}