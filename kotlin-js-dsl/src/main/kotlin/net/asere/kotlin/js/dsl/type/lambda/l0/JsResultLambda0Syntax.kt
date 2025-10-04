package net.asere.kotlin.js.dsl.type.lambda.l0

import net.asere.kotlin.js.dsl.annotation.JsInternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsResultLambda0Syntax<Result : JsValue> @JsInternalApi constructor(
    value: String,
    private val resultTypeBuilder: (JsElement) -> Result,
    isNullable: Boolean
) : JsReferenceSyntax<JsLambda0>(value, isNullable), JsResultLambda0<Result> {
    @JsInternalApi  constructor(
        value: JsElement,
        resultTypeBuilder: (JsElement) -> Result,
        isNullable: Boolean
    ) : this("$value", resultTypeBuilder, isNullable)


    override fun invoke(): Result = resultTypeBuilder(InvocationOperation(this))
}

@OptIn(JsInternalApi::class)
inline fun <reified Result : JsValue> JsResultLambda0.Companion.syntax(
    value: String,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false
): JsResultLambda0<Result> = JsResultLambda0Syntax(
    value = value,
    resultTypeBuilder = { element -> provide(element, isResultNullable) },
    isNullable = isNullable,
)

@OptIn(JsInternalApi::class)
inline fun <reified Result : JsValue> JsResultLambda0.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false
): JsResultLambda0<Result> = JsResultLambda0Syntax(
    value = value,
    resultTypeBuilder = { element -> provide(element, isResultNullable) },
    isNullable = isNullable,
)

@OptIn(JsInternalApi::class)
fun <Result : JsValue> JsResultLambda0.Companion.syntax(
    value: String,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
    resultTypeBuilder: (JsElement, Boolean) -> Result,
): JsResultLambda0<Result> = JsResultLambda0Syntax(
    value = value,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable) },
    isNullable = isNullable,
)

@OptIn(JsInternalApi::class)
fun <Result : JsValue> JsResultLambda0.Companion.syntax(
    value: JsElement,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
    resultTypeBuilder: (JsElement, Boolean) -> Result,
): JsResultLambda0<Result> = JsResultLambda0Syntax(
    value = value,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable) },
    isNullable = isNullable,
)