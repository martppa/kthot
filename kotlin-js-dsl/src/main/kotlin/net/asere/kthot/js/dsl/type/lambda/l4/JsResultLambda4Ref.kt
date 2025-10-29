package net.asere.kthot.js.dsl.type.lambda.l4

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.lambda.JsLambdaRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda4Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Result : JsValue>(
    name: String,
    internal val resultTypeBuilder: (JsElement) -> Result,
) : JsLambdaRef<JsResultLambda4<Param1, Param2, Param3, Param4, Result>>(name),
    JsResultLambda4<Param1, Param2, Param3, Param4, Result> {

    override fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4): Result =
        resultTypeBuilder(InvocationOperation(this))
}

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, reified Result : JsValue> JsResultLambda4.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda4Ref<Param1, Param2, Param3, Param4, Result> = JsResultLambda4Ref(
    name = name,
    resultTypeBuilder = resultTypeBuilder,
)

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, reified Result : JsValue> JsResultLambda4.Companion.ref(
    element: JsElement,
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda4Ref<Param1, Param2, Param3, Param4, Result> = JsResultLambda4Ref(
    name = element.present(),
    resultTypeBuilder = resultTypeBuilder,
)

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, reified Result : JsValue> JsLambda4.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
) = object :
    JsPrintableDefinition<JsResultLambda4Ref<Param1, Param2, Param3, Param4, Result>, JsResultLambda4<Param1, Param2, Param3, Param4, Result>>() {
    override val reference: JsResultLambda4Ref<Param1, Param2, Param3, Param4, Result> = JsResultLambda4Ref(
        name = name,
        resultTypeBuilder = resultTypeBuilder,
    )
}