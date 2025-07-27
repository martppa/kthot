package net.asere.kotlin.js.dsl.types.reference.lambda

import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.ReferenceId
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda5
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsLambda5Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue>(
    name: String,
    isNullable: Boolean = false
) : JsLambdaRefCommons<JsLambda5<Param1, Param2, Param3, Param4, Param5>>(name, isNullable),
    JsLambda5<Param1, Param2, Param3, Param4, Param5>

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsLambda5.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}"
): JsLambda5Ref<Param1, Param2, Param3, Param4, Param5> = JsLambda5Ref(name)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsLambda5.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}"
) = object :
    JsDefinition<JsLambda5Ref<Param1, Param2, Param3, Param4, Param5>, JsLambda5<Param1, Param2, Param3, Param4, Param5>> {
    override val reference: JsLambda5Ref<Param1, Param2, Param3, Param4, Param5> = JsLambda5Ref(name)
}