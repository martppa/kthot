package net.asere.kotlin.js.dsl.type

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.value.JsValue

interface JsLambda2<Param1 : JsValue, Param2 : JsValue> : JsValue {
    operator fun invoke(param1: Param1, param2: Param2) = JsSyntax("$this($param1, $param2)")

    companion object
}