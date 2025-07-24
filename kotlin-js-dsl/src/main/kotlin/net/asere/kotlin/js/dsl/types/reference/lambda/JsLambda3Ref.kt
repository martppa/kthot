package net.asere.kotlin.js.dsl.types.reference.lambda

import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda3
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsLambda3Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue>(
    name: String,
) : JsLambdaRefCommons<JsLambda3<Param1, Param2, Param3>>(name), JsLambda3<Param1, Param2, Param3>

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.ref(
    name: String = "lambda_${JsReference.nextRefInt()}"
): JsLambda3Ref<Param1, Param2, Param3> = JsLambda3Ref(name)