package net.asere.kotlin.js.dsl.types.reference.function

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsFunction5Ref<
        Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue,
        Param5 : JsValue>(
    name: String? = null,
) : JsFunctionRefCommons(name) {
    operator fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4, param5: Param5) =
        JsSyntax("$this($param1, $param2, $param3, $param4, $param5)")
}