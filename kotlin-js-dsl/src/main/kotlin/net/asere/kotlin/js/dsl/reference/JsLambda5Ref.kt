package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.type.JsLambda5
import net.asere.kotlin.js.dsl.value.JsValue

class JsLambda5Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue>(
    name: String,
) : JsLambdaRefCommons<JsLambda5<Param1, Param2, Param3, Param4, Param5>>(name),
    JsLambda5<Param1, Param2, Param3, Param4, Param5>

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsLambda5.Companion.ref(
    name: String = "lambda_${JsReference.nextRefInt()}"
): JsLambda5Ref<Param1, Param2, Param3, Param4, Param5> = JsLambda5Ref(name)