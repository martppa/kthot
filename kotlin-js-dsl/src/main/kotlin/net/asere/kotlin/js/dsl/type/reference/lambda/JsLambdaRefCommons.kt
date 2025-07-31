package net.asere.kotlin.js.dsl.type.reference.lambda

import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.value.JsValue

abstract class JsLambdaRefCommons<T : JsValue>(
    name: String,
    isNullable: Boolean = false
) : JsValueRef<T>(name, isNullable) {
    override fun toString(): String = present()
}