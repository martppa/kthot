package net.asere.kthot.js.dsl.type.lambda.l1

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.lambda.JsLambdaRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda1Ref<Param1 : JsValue, Result : JsValue>(
    name: String,
    internal val resultTypeBuilder: (JsElement) -> Result,
) : JsLambdaRef<JsResultLambda1<Param1, Result>>(name), JsResultLambda1<Param1, Result> {

    override fun invoke(param: Param1): Result = resultTypeBuilder(InvocationOperation(this))
}

inline fun <Param1 : JsValue, reified Result : JsValue> JsResultLambda1.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda1Ref<Param1, Result> = JsResultLambda1Ref(
    name = name,
    resultTypeBuilder = resultTypeBuilder,
)

inline fun <Param1 : JsValue, reified Result : JsValue> JsResultLambda1.Companion.ref(
    element: JsElement,
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda1Ref<Param1, Result> = JsResultLambda1Ref(
    name = element.present(),
    resultTypeBuilder = resultTypeBuilder,
)

inline fun <Param1 : JsValue, reified Result : JsValue> JsLambda1.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
) = object : JsPrintableDefinition<JsResultLambda1Ref<Param1, Result>, JsResultLambda1<Param1, Result>>() {
    override val reference: JsResultLambda1Ref<Param1, Result> = JsResultLambda1Ref(
        name = name,
        resultTypeBuilder = resultTypeBuilder,
    )
}