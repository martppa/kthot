package net.asere.kotlin.js.dsl.types.type.lambda

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.types.value.JsValue

interface JsLambda1<Param1 : JsValue> : JsValue {
    operator fun invoke(param: Param1) = JsSyntax("$this($param)")

    companion object
}