package net.asere.kotlin.js.dsl.type.lambda.l2

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRef
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsLambda2Ref<Param1 : JsValue, Param2 : JsValue>(
    name: String,
    isNullable: Boolean = false
) : JsLambdaRef<JsLambda2<Param1, Param2>>(name, isNullable), JsLambda2<Param1, Param2>

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
): JsLambda2Ref<Param1, Param2> = JsLambda2Ref(name, isNullable)

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.ref(
    element: JsElement, isNullable: Boolean = false
): JsLambda2Ref<Param1, Param2> = JsLambda2Ref(element.present(), isNullable)

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
) = object : JsPrintableDefinition<JsLambda2Ref<Param1, Param2>, JsLambda2<Param1, Param2>>() {
    override val reference: JsLambda2Ref<Param1, Param2> = JsLambda2Ref(name, isNullable)
}