package net.asere.kthot.js.dsl.type.lambda.l3

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.lambda.JsLambdaRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLambda3Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue>(
    name: String,
) : JsLambdaRef<JsLambda3<Param1, Param2, Param3>>(name), JsLambda3<Param1, Param2, Param3>

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
): JsLambda3Ref<Param1, Param2, Param3> = JsLambda3Ref(name)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.ref(
    element: JsElement,
): JsLambda3Ref<Param1, Param2, Param3> = JsLambda3Ref(element.present())

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}"
) = object : JsPrintableDefinition<JsLambda3Ref<Param1, Param2, Param3>, JsLambda3<Param1, Param2, Param3>>() {
    override val reference: JsLambda3Ref<Param1, Param2, Param3> = JsLambda3Ref(name)
}