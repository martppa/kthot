package net.asere.kotlin.js.dsl.types.reference.lambda

import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda2
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsLambda2Ref<Param1 : JsValue, Param2 : JsValue>(
    name: String,
) : JsLambdaRefCommons<JsLambda2<Param1, Param2>>(name), JsLambda2<Param1, Param2>

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.ref(
    name: String = "lambda_${JsReference.nextRefInt()}"
): JsLambda2Ref<Param1, Param2> = JsLambda2Ref(name)