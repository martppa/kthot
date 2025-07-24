package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.type.JsLambda3
import net.asere.kotlin.js.dsl.type.JsLambda4
import net.asere.kotlin.js.dsl.value.JsValue

class JsLambda4Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue>(
    name: String,
) : JsLambdaRefCommons<JsLambda4<Param1, Param2, Param3, Param4>>(name), JsLambda4<Param1, Param2, Param3, Param4>

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsLambda4.Companion.ref(
    name: String = "lambda_${JsReference.nextRefInt()}"
): JsLambda4Ref<Param1, Param2, Param3, Param4> = JsLambda4Ref(name)