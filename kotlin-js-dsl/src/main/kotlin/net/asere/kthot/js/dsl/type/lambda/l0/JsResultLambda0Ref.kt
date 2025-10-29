package net.asere.kthot.js.dsl.type.lambda.l0

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.lambda.JsLambdaRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda0Ref<Result : JsValue>(
    name: String,
    internal val resultTypeBuilder: (JsElement) -> Result,
) : JsLambdaRef<JsResultLambda0<Result>>(name), JsResultLambda0<Result> {

    override fun invoke(): Result = resultTypeBuilder(InvocationOperation(this))
}

inline fun <reified Result : JsValue> JsResultLambda0.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda0<Result> = JsResultLambda0Ref(
    name = name,
    resultTypeBuilder = resultTypeBuilder,
)

inline fun <reified Result : JsValue> JsResultLambda0.Companion.ref(
    element: JsElement,
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda0<Result> = JsResultLambda0Ref(
    name = element.present(),
    resultTypeBuilder = resultTypeBuilder,
)

inline fun <reified Result : JsValue> JsResultLambda0.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
) = object : JsPrintableDefinition<JsResultLambda0Ref<Result>, JsResultLambda0<Result>>() {
    override val reference: JsResultLambda0Ref<Result> = JsResultLambda0Ref(
        name = name,
        resultTypeBuilder = resultTypeBuilder,
    )
}