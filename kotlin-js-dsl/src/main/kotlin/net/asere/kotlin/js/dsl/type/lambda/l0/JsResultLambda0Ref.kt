package net.asere.kotlin.js.dsl.type.lambda.l0

import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsResultLambda0Ref<Result : JsValue>(
    name: String,
    internal val resultTypeBuilder: (JsElement) -> Result,
    isNullable: Boolean = false
) : JsLambdaRef<JsResultLambda0<Result>>(name, isNullable), JsResultLambda0<Result> {

    override fun invoke(): Result = resultTypeBuilder(InvocationOperation(this))
}

inline fun <reified Result : JsValue> JsResultLambda0.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda0<Result> = JsResultLambda0Ref(
    name = name,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
    isNullable = isNullable
)

inline fun <reified Result : JsValue> JsResultLambda0.Companion.ref(
    element: JsElement,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda0<Result> = JsResultLambda0Ref(
    name = element.present(),
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
    isNullable = isNullable
)

inline fun <reified Result : JsValue> JsResultLambda0.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
) = object : JsPrintableDefinition<JsResultLambda0Ref<Result>, JsResultLambda0<Result>>() {
    override val reference: JsResultLambda0Ref<Result> = JsResultLambda0Ref(
        name = name,
        resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
        isNullable = isNullable
    )
}