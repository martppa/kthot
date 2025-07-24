package net.asere.kotlin.js.dsl.types.type.lambda

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.types.value.JsValue

interface JsLambda5<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> :
    JsValue {
    operator fun invoke(
        param1: Param1,
        param2: Param2,
        param3: Param3,
        param4: Param4,
        param5: Param5,
    ) = JsSyntax("$this($param1, $param2, $param3, $param4, $param5)")

    companion object
}