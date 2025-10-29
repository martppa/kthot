package net.asere.kthot.js.dsl.type.lambda.l0

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda0Syntax<Result : JsValue> @JsInternalApi constructor(
    value: String,
    private val resultTypeBuilder: (JsElement) -> Result,
) : JsReferenceSyntax<JsLambda0>(value), JsResultLambda0<Result> {
    @JsInternalApi  constructor(
        value: JsElement,
        resultTypeBuilder: (JsElement) -> Result,
    ) : this("$value", resultTypeBuilder)


    override fun invoke(): Result = resultTypeBuilder(InvocationOperation(this))
}

@OptIn(JsInternalApi::class)
inline fun <reified Result : JsValue> JsResultLambda0.Companion.syntax(
    value: String,
): JsResultLambda0<Result> = JsResultLambda0Syntax(
    value = value,
    resultTypeBuilder = { element -> provide(element) },
)

@OptIn(JsInternalApi::class)
inline fun <reified Result : JsValue> JsResultLambda0.Companion.syntax(
    value: JsElement,
): JsResultLambda0<Result> = JsResultLambda0Syntax(
    value = value,
    resultTypeBuilder = { element -> provide(element) },
)

@OptIn(JsInternalApi::class)
fun <Result : JsValue> JsResultLambda0.Companion.syntax(
    value: String,
    resultTypeBuilder: (JsElement) -> Result,
): JsResultLambda0<Result> = JsResultLambda0Syntax(
    value = value,
    resultTypeBuilder = resultTypeBuilder,
)

@OptIn(JsInternalApi::class)
fun <Result : JsValue> JsResultLambda0.Companion.syntax(
    value: JsElement,
    resultTypeBuilder: (JsElement) -> Result,
): JsResultLambda0<Result> = JsResultLambda0Syntax(
    value = value,
    resultTypeBuilder = resultTypeBuilder,
)