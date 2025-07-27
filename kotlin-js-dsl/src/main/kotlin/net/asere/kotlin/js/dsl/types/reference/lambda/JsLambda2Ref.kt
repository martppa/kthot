package net.asere.kotlin.js.dsl.types.reference.lambda

import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.ReferenceId
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda2
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsLambda2Ref<Param1 : JsValue, Param2 : JsValue>(
    name: String,
    isNullable: Boolean = false
) : JsLambdaRefCommons<JsLambda2<Param1, Param2>>(name, isNullable), JsLambda2<Param1, Param2>

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}"
): JsLambda2Ref<Param1, Param2> = JsLambda2Ref(name)

fun <Param1 : JsValue, Param2 : JsValue> JsLambda2.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}"
) = object : JsPrintableDefinition<JsLambda2Ref<Param1, Param2>, JsLambda2<Param1, Param2>>() {
    override val reference: JsLambda2Ref<Param1, Param2> = JsLambda2Ref(name)
}