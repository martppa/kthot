package net.asere.kthot.js.dsl.type.lambda.l4

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda4Syntax<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Result : JsValue> @JsInternalApi constructor(
    value: String,
    private val resultTypeBuilder: (JsElement) -> Result,
) : JsReferenceSyntax<JsLambda4<Param1, Param2, Param3, Param4>>(value),
    JsResultLambda4<Param1, Param2, Param3, Param4, Result> {

    @JsInternalApi
    constructor(
        value: JsElement,
        resultTypeBuilder: (JsElement) -> Result,
    ) : this("$value", resultTypeBuilder)

    override fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4): Result =
        resultTypeBuilder(InvocationOperation(this, param1, param2, param3, param4))
}

@OptIn(JsInternalApi::class)
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Result : JsValue> JsResultLambda4.Companion.syntax(
    value: String,
    resultTypeBuilder: (JsElement) -> Result,
): JsResultLambda4<Param1, Param2, Param3, Param4, Result> = JsResultLambda4Syntax(
    value = value,
    resultTypeBuilder = resultTypeBuilder,
)

@OptIn(JsInternalApi::class)
inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, reified Result : JsValue> JsResultLambda4.Companion.syntax(
    value: JsElement,
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda4<Param1, Param2, Param3, Param4, Result> = JsResultLambda4Syntax(
    value = value,
    resultTypeBuilder = resultTypeBuilder,
)