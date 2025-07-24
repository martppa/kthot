package net.asere.kotlin.js.dsl.types.reference.lambda

import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsLambda1Ref<Param1 : JsValue>(
    name: String,
) : JsLambdaRefCommons<JsLambda1<Param1>>(name), JsLambda1<Param1>

fun <Param1 : JsValue> JsLambda1.Companion.ref(
    name: String = "lambda_${JsReference.nextRefInt()}"
): JsLambda1Ref<Param1> = JsLambda1Ref(name)

fun <Param1 : JsValue> JsLambda1.Companion.def(
    name: String = "lambda_${JsReference.nextRefInt()}"
) = object : JsDefinition<JsLambda1Ref<Param1>, JsLambda1<Param1>> {
    override val reference: JsLambda1Ref<Param1> = JsLambda1Ref(name)
}