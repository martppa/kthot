package net.asere.kthot.js.dsl.type.lambda.l1

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.lambda.JsLambdaRef
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLambda1Ref<Param1 : JsValue>(
    name: String,
    isNullable: Boolean = false,
) : JsLambdaRef<JsLambda1<Param1>>(name, isNullable), JsLambda1<Param1>

fun <Param1 : JsValue> JsLambda1.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    isNullable: Boolean = false
): JsLambda1Ref<Param1> = JsLambda1Ref(name, isNullable)

fun <Param1 : JsValue> JsLambda1.Companion.ref(
    element: JsElement,
    isNullable: Boolean = false
): JsLambda1Ref<Param1> = JsLambda1Ref(element.present(), isNullable)

fun <Param1 : JsValue> JsLambda1.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
) = object : JsPrintableDefinition<JsLambda1Ref<Param1>, JsLambda1<Param1>>() {
    override val reference: JsLambda1Ref<Param1> = JsLambda1Ref(name, isNullable)
}