package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.callable.*
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.value.JsValue

fun JsLambda.Companion.ref(name: String? = null) = JsLambdaRef(name)

fun <Param1 : JsValue> JsLambda1.Companion.ref(name: String? = null) = JsLambda1Ref<Param1>(name)

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.ref(name: String? = null) =
    JsLambda2Ref<Param1, Param2>(name)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.ref(name: String? = null) =
    JsLambda3Ref<Param1, Param2, Param3>(name)

fun <Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue> JsLambda4.Companion.ref(name: String? = null) =
    JsLambda4Ref<Param1, Param2, Param3, Param4>(name)

fun <Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue,
        Param5 : JsValue> JsLambda5.Companion.ref(name: String? = null) =
    JsLambda5Ref<Param1, Param2, Param3, Param4, Param5>(name)

class JsLambda5Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue>(
    name: String? = null,
) : JsLambdaRefCommons(name) {

    operator fun invoke(
        param1: Param1,
        param2: Param2,
        param3: Param3,
        param4: Param4,
        param5: Param5
    ) = JsSyntax("$this($param1, $param2, $param3, $param4, $param5)")
}

class JsLambda4Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue>(
    name: String? = null,
) : JsLambdaRefCommons(name) {

    operator fun invoke(
        param1: Param1,
        param2: Param2,
        param3: Param3,
        param4: Param4,
    ) = JsSyntax("$this($param1, $param2, $param3, $param4)")
}

class JsLambda3Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue>(
    name: String? = null,
) : JsLambdaRefCommons(name) {

    operator fun invoke(param1: Param1, param2: Param2, param3: Param3) = JsSyntax("$this($param1, $param2, $param3)")
}

class JsLambda2Ref<Param1 : JsValue, Param2 : JsValue>(
    name: String? = null,
) : JsValueRef<JsValue>(name) {

    operator fun invoke(param1: Param1, param2: Param2) = JsSyntax("$this($param1, $param2)")

    override fun toString(): String = present()
}

class JsLambda1Ref<Param1 : JsValue>(
    name: String? = null,
) : JsLambdaRefCommons(name) {
    operator fun invoke(param: Param1) = JsSyntax("$this($param)")
}

class JsLambdaRef(
    name: String? = null
) : JsLambdaRefCommons(name) {

    operator fun invoke() = JsSyntax("$this()")
}

abstract class JsLambdaRefCommons(
    name: String? = null
) : JsValueRef<JsValue>(name ?: "lambda_${JsReference.nextRefInt()}") {
    override fun toString(): String = present()
}