package net.asere.kotlin.js.dsl.type.lambda.l5

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRefCommons
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsLambda5Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue>(
    name: String,
    isNullable: Boolean = false
) : JsLambdaRefCommons<JsLambda5<Param1, Param2, Param3, Param4, Param5>>(name, isNullable),
    JsLambda5<Param1, Param2, Param3, Param4, Param5>

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsLambda5.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
): JsLambda5Ref<Param1, Param2, Param3, Param4, Param5> = JsLambda5Ref(name, isNullable)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsLambda5.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
) = object :
    JsPrintableDefinition<JsLambda5Ref<Param1, Param2, Param3, Param4, Param5>, JsLambda5<Param1, Param2, Param3, Param4, Param5>>() {
    override val reference: JsLambda5Ref<Param1, Param2, Param3, Param4, Param5> = JsLambda5Ref(name, isNullable)
}