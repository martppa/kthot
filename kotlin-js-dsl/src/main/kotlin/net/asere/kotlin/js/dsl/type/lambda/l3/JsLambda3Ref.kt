package net.asere.kotlin.js.dsl.type.lambda.l3

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsLambda3Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue>(
    name: String,
    isNullable: Boolean = false
) : JsLambdaRef<JsLambda3<Param1, Param2, Param3>>(name, isNullable), JsLambda3<Param1, Param2, Param3>

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
): JsLambda3Ref<Param1, Param2, Param3> = JsLambda3Ref(name, isNullable)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.ref(
    element: JsElement, isNullable: Boolean = false
): JsLambda3Ref<Param1, Param2, Param3> = JsLambda3Ref(element.present(), isNullable)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsLambda3.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
) = object : JsPrintableDefinition<JsLambda3Ref<Param1, Param2, Param3>, JsLambda3<Param1, Param2, Param3>>() {
    override val reference: JsLambda3Ref<Param1, Param2, Param3> = JsLambda3Ref(name, isNullable)
}