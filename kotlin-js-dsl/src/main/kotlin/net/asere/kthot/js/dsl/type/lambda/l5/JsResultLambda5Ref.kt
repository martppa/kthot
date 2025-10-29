package net.asere.kthot.js.dsl.type.lambda.l5

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.lambda.JsLambdaRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda5Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue, Result : JsValue>(
    name: String,
    internal val resultTypeBuilder: (JsElement) -> Result,
) : JsLambdaRef<JsResultLambda5<Param1, Param2, Param3, Param4, Param5, Result>>(name), JsResultLambda5<Param1, Param2, Param3, Param4, Param5, Result> {

    override fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4, param5: Param5): Result = resultTypeBuilder(InvocationOperation(this))
}

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue, reified Result : JsValue> JsResultLambda5.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda5Ref<Param1, Param2, Param3, Param4, Param5, Result> = JsResultLambda5Ref(
    name = name,
    resultTypeBuilder = resultTypeBuilder,
)

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue, reified Result : JsValue> JsResultLambda5.Companion.ref(
    element: JsElement,
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda5Ref<Param1, Param2, Param3, Param4, Param5, Result> = JsResultLambda5Ref(
    name = element.present(),
    resultTypeBuilder = resultTypeBuilder,
)

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue, reified Result : JsValue> JsLambda5.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
) = object : JsPrintableDefinition<JsResultLambda5Ref<Param1, Param2, Param3, Param4, Param5, Result>, JsResultLambda5<Param1, Param2, Param3, Param4, Param5, Result>>() {
    override val reference: JsResultLambda5Ref<Param1, Param2, Param3, Param4, Param5, Result> = JsResultLambda5Ref(
        name = name,
        resultTypeBuilder = resultTypeBuilder,
    )
}