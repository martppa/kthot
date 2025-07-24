package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.value.JsValue

abstract class JsLambdaRefCommons<T : JsValue>(
    name: String
) : JsValueRef<T>(name) {
    override fun toString(): String = present()
}