package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.callable.*
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.value.JsValue

fun JsLambda0.Companion.ref(name: String = "lambda_${JsReference.nextRefInt()}") = JsLambdaRef(name)

fun <Param1 : JsValue> JsLambda1.Companion.ref(
    name: String = "lambda_${JsReference.nextRefInt()}"
): JsLambda1Ref<Param1> = JsLambda1Ref(name)

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.ref(
    name: String = "lambda_${JsReference.nextRefInt()}"
) = JsLambda2Ref<Param1, Param2>(name)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.ref(
    name: String = "lambda_${JsReference.nextRefInt()}"
) = JsLambda3Ref<Param1, Param2, Param3>(name)

fun <Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue> JsLambda4.Companion.ref(name: String) =
    JsLambda4Ref<Param1, Param2, Param3, Param4>(name)

fun <Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue,
        Param5 : JsValue> JsLambda5.Companion.ref(
    name: String = "lambda_${JsReference.nextRefInt()}"
) = JsLambda5Ref<Param1, Param2, Param3, Param4, Param5>(name)

class JsLambda5Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue>(
    name: String,
) : JsLambdaRefCommons<JsLambda5Ref<Param1, Param2, Param3, Param4, Param5>>(name) {

    operator fun invoke(
        param1: Param1,
        param2: Param2,
        param3: Param3,
        param4: Param4,
        param5: Param5
    ) = JsSyntax("$this($param1, $param2, $param3, $param4, $param5)")
}

class JsLambda4Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue>(
    name: String,
) : JsLambdaRefCommons<JsLambda4Ref<Param1, Param2, Param3, Param4>>(name) {

    operator fun invoke(
        param1: Param1,
        param2: Param2,
        param3: Param3,
        param4: Param4,
    ) = JsSyntax("$this($param1, $param2, $param3, $param4)")
}

class JsLambda3Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue>(
    name: String,
) : JsLambdaRefCommons<JsLambda3Ref<Param1, Param2, Param3>>(name) {

    operator fun invoke(param1: Param1, param2: Param2, param3: Param3) = JsSyntax("$this($param1, $param2, $param3)")
}

class JsLambda2Ref<Param1 : JsValue, Param2 : JsValue>(
    name: String,
) : JsValueRef<JsValue>(name) {

    operator fun invoke(param1: Param1, param2: Param2) = JsSyntax("$this($param1, $param2)")

    override fun toString(): String = present()
}

class JsLambda1Ref<Param1 : JsValue>(
    name: String,
) : JsLambdaRefCommons<JsLambda1Ref<Param1>>(name) {
    operator fun invoke(param: Param1) = JsSyntax("$this($param)")
}

class JsLambdaRef(
    name: String
) : JsLambdaRefCommons<JsLambdaRef>(name) {

    operator fun invoke() = JsSyntax("$this()")
}

abstract class JsLambdaRefCommons<T : JsValue>(
    name: String
) : JsValueRef<T>(name) {
    override fun toString(): String = present()
}