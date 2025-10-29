package net.asere.kthot.js.dsl.type.lambda.l1

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda1Syntax<Param1 : JsValue, Result : JsValue> @JsInternalApi constructor(
    value: String,
    private val resultTypeBuilder: (JsElement) -> Result,
) : JsReferenceSyntax<JsLambda1<Param1>>(value), JsResultLambda1<Param1, Result> {
    @JsInternalApi constructor(
        value: JsElement,
        resultTypeBuilder: (JsElement) -> Result,
    ) : this("$value", resultTypeBuilder)

    override fun invoke(param: Param1): Result = resultTypeBuilder(InvocationOperation(this, param))
}

@OptIn(JsInternalApi::class)
inline fun <Param1 : JsValue, reified Result : JsValue> JsResultLambda1.Companion.syntax(
    value: String,
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda1<Param1, Result> = JsResultLambda1Syntax(
    value = value,
    resultTypeBuilder = resultTypeBuilder,
)

@OptIn(JsInternalApi::class)
inline fun <Param1 : JsValue, reified Result : JsValue> JsResultLambda1.Companion.syntax(
    value: JsElement,
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda1<Param1, Result> = JsResultLambda1Syntax(
    value = value,
    resultTypeBuilder = resultTypeBuilder,
)