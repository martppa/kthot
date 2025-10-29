package net.asere.kthot.js.dsl.type.lambda.l3

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda3Syntax<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Result : JsValue> @JsInternalApi constructor(
    value: String,
    private val resultTypeBuilder: (JsElement) -> Result,
) : JsReferenceSyntax<JsLambda3<Param1, Param2, Param3>>(value), JsResultLambda3<Param1, Param2, Param3, Result> {

    @JsInternalApi constructor(
        value: JsElement,
        resultTypeBuilder: (JsElement) -> Result,
    ) : this("$value", resultTypeBuilder)

    override fun invoke(param1: Param1, param2: Param2, param3: Param3): Result =
        resultTypeBuilder(InvocationOperation(this, param1, param2, param3))
}

@OptIn(JsInternalApi::class)
inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, reified Result : JsValue> JsResultLambda3.Companion.syntax(
    value: String,
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda3<Param1, Param2, Param3, Result> = JsResultLambda3Syntax(
    value = value,
    resultTypeBuilder = resultTypeBuilder,
)

@OptIn(JsInternalApi::class)
inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, reified Result : JsValue> JsResultLambda3.Companion.syntax(
    value: JsElement,
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda3<Param1, Param2, Param3, Result> = JsResultLambda3Syntax(
    value = value,
    resultTypeBuilder = resultTypeBuilder,
)