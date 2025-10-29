package net.asere.kthot.js.dsl.type.lambda.l2

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.lambda.JsLambdaRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLambda2Ref<Param1 : JsValue, Param2 : JsValue>(
    name: String,
) : JsLambdaRef<JsLambda2<Param1, Param2>>(name), JsLambda2<Param1, Param2>

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
): JsLambda2Ref<Param1, Param2> = JsLambda2Ref(name)

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.ref(
    element: JsElement,
): JsLambda2Ref<Param1, Param2> = JsLambda2Ref(element.present())

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
) = object : JsPrintableDefinition<JsLambda2Ref<Param1, Param2>, JsLambda2<Param1, Param2>>() {
    override val reference: JsLambda2Ref<Param1, Param2> = JsLambda2Ref(name)
}