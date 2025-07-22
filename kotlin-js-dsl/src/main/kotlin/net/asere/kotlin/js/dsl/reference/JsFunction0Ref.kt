package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.value.JsValue

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

class JsFunction4Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue>(
    name: String? = null,
) : JsFunctionRefCommons(name) {
    operator fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4) =
        JsSyntax("$this($param1, $param2, $param3, $param4)")
}

class JsFunction3Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue>(
    name: String? = null,
) : JsFunctionRefCommons(name) {
    operator fun invoke(param1: Param1, param2: Param2, param3: Param3) =
        JsSyntax("$this($param1, $param2, $param3)")
}

class JsFunction2Ref<Param1 : JsValue, Param2 : JsValue>(
    name: String? = null,
) : JsFunctionRefCommons(name) {
    operator fun invoke(param1: Param1, param2: Param2) = JsSyntax("$this($param1, $param2)")
}

class JsFunction1Ref<Param1 : JsValue>(
    name: String? = null,
) : JsFunctionRefCommons(name) {
    operator fun invoke(param: Param1) = JsSyntax("$this($param)")
}

class JsFunction0Ref(
    name: String? = null,
) : JsFunctionRefCommons(name) {
    operator fun invoke() = JsSyntax("$this()")
}

abstract class JsFunctionRefCommons(
    name: String? = null,
) : JsObjectRef(name ?: "function_${JsReference.nextRefInt()}") {
    override fun toString(): String = present()
}
