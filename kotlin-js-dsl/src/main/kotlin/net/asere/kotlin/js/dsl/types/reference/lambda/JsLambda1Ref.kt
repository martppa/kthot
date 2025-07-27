package net.asere.kotlin.js.dsl.types.reference.lambda

import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.ReferenceId
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsLambda1Ref<Param1 : JsValue>(
    name: String,
    isNullable: Boolean = false,
) : JsLambdaRefCommons<JsLambda1<Param1>>(name, isNullable), JsLambda1<Param1>

fun <Param1 : JsValue> JsLambda1.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    isNullable: Boolean = false
): JsLambda1Ref<Param1> = JsLambda1Ref(name, isNullable)

fun <Param1 : JsValue> JsLambda1.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
) = object : JsPrintableDefinition<JsLambda1Ref<Param1>, JsLambda1<Param1>>() {
    override val reference: JsLambda1Ref<Param1> = JsLambda1Ref(name, isNullable)
}