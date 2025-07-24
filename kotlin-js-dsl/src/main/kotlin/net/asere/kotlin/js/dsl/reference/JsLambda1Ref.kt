package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.type.JsLambda1
import net.asere.kotlin.js.dsl.value.JsValue

class JsLambda1Ref<Param1 : JsValue>(
    name: String,
) : JsLambdaRefCommons<JsLambda1<Param1>>(name), JsLambda1<Param1>

fun <Param1 : JsValue> JsLambda1.Companion.ref(
    name: String = "lambda_${JsReference.nextRefInt()}"
): JsLambda1Ref<Param1> = JsLambda1Ref(name)