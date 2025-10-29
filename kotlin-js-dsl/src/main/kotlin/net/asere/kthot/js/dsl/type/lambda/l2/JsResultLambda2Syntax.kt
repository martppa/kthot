package net.asere.kthot.js.dsl.type.lambda.l2

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda2Syntax<Param1 : JsValue, Param2 : JsValue, Result : JsValue> @JsInternalApi constructor(
    value: String,
    private val resultTypeBuilder: (JsElement) -> Result,
) : JsReferenceSyntax<JsLambda2<Param1, Param2>>(value), JsResultLambda2<Param1, Param2, Result> {

    @JsInternalApi constructor(
        value: JsElement,
        resultTypeBuilder: (JsElement) -> Result,
    ) : this("$value", resultTypeBuilder)

    override fun invoke(param1: Param1, param2: Param2): Result =
        resultTypeBuilder(InvocationOperation(this, param1, param2))
}

@OptIn(JsInternalApi::class)
inline fun <Param1 : JsValue, Param2 : JsValue, reified Result : JsValue> JsResultLambda2.Companion.syntax(
    value: String,
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda2<Param1, Param2, Result> = JsResultLambda2Syntax(
    value = value,
    resultTypeBuilder = resultTypeBuilder,
)

@OptIn(JsInternalApi::class)
inline fun <Param1 : JsValue, Param2 : JsValue, reified Result : JsValue> JsResultLambda2.Companion.syntax(
    value: JsElement,
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda2<Param1, Param2, Result> = JsResultLambda2Syntax(
    value = value,
    resultTypeBuilder = resultTypeBuilder,
)