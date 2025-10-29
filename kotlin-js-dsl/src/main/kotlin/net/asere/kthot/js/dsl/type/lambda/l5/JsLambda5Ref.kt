package net.asere.kthot.js.dsl.type.lambda.l5

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.lambda.JsLambdaRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLambda5Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue>(
    name: String,
) : JsLambdaRef<JsLambda5<Param1, Param2, Param3, Param4, Param5>>(name),
    JsLambda5<Param1, Param2, Param3, Param4, Param5>

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsLambda5.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
): JsLambda5Ref<Param1, Param2, Param3, Param4, Param5> = JsLambda5Ref(name)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsLambda5.Companion.ref(
    element: JsElement,
): JsLambda5Ref<Param1, Param2, Param3, Param4, Param5> = JsLambda5Ref(element.present())

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> JsLambda5.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
) = object :
    JsPrintableDefinition<JsLambda5Ref<Param1, Param2, Param3, Param4, Param5>, JsLambda5<Param1, Param2, Param3, Param4, Param5>>() {
    override val reference: JsLambda5Ref<Param1, Param2, Param3, Param4, Param5> = JsLambda5Ref(name)
}