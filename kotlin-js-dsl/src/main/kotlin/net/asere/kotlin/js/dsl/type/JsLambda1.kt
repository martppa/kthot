package net.asere.kotlin.js.dsl.type

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.value.JsValue

interface JsLambda1<Param1 : JsValue> : JsValue {
    operator fun invoke(param: Param1) = JsSyntax("$this($param)")

    companion object
}