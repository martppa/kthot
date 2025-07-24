package net.asere.kotlin.js.dsl.types.reference.function

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsFunction1Ref<Param1 : JsValue>(
    name: String? = null,
) : JsFunctionRefCommons(name) {
    operator fun invoke(param: Param1) = JsSyntax("$this($param)")
}