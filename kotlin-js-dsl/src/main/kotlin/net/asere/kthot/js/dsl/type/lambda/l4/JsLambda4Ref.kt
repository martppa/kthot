package net.asere.kthot.js.dsl.type.lambda.l4

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.lambda.JsLambdaRef
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLambda4Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue>(
    name: String,
    isNullable: Boolean = false
) : JsLambdaRef<JsLambda4<Param1, Param2, Param3, Param4>>(name, isNullable), JsLambda4<Param1, Param2, Param3, Param4>

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsLambda4.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
): JsLambda4Ref<Param1, Param2, Param3, Param4> = JsLambda4Ref(name, isNullable)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsLambda4.Companion.ref(
    element: JsElement, isNullable: Boolean = false
): JsLambda4Ref<Param1, Param2, Param3, Param4> = JsLambda4Ref(element.present(), isNullable)

fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsLambda4.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
) = object :
    JsPrintableDefinition<JsLambda4Ref<Param1, Param2, Param3, Param4>, JsLambda4<Param1, Param2, Param3, Param4>>() {
    override val reference: JsLambda4Ref<Param1, Param2, Param3, Param4> = JsLambda4Ref(name, isNullable)
}