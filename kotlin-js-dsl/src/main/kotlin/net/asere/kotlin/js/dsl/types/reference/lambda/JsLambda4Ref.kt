package net.asere.kotlin.js.dsl.types.reference.lambda

import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda4
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsLambda4Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue>(
    name: String,
    isNullable: Boolean = false
) : JsLambdaRefCommons<JsLambda4<Param1, Param2, Param3, Param4>>(name, isNullable), JsLambda4<Param1, Param2, Param3, Param4>

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsLambda4.Companion.ref(
    name: String = "lambda_${JsReference.nextRefInt()}"
): JsLambda4Ref<Param1, Param2, Param3, Param4> = JsLambda4Ref(name)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsLambda4.Companion.def(
    name: String = "lambda_${JsReference.nextRefInt()}"
) = object :
    JsPrintableDefinition<JsLambda4Ref<Param1, Param2, Param3, Param4>, JsLambda4<Param1, Param2, Param3, Param4>>() {
    override val reference: JsLambda4Ref<Param1, Param2, Param3, Param4> = JsLambda4Ref(name)
}