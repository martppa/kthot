package net.asere.kthot.js.dsl.type.lambda.l5

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda5Syntax<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue, Result : JsValue> @JsInternalApi constructor(
    value: String,
    private val resultTypeBuilder: (JsElement) -> Result,
    isNullable: Boolean
) : JsReferenceSyntax<JsLambda5<Param1, Param2, Param3, Param4, Param5>>(value, isNullable),
    JsResultLambda5<Param1, Param2, Param3, Param4, Param5, Result> {

    @JsInternalApi
    constructor(
        value: JsElement,
        resultTypeBuilder: (JsElement) -> Result,
        isNullable: Boolean
    ) : this("$value", resultTypeBuilder, isNullable)

    override fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4, param5: Param5): Result =
        resultTypeBuilder(InvocationOperation(this, param1, param2, param3, param4, param5))
}

@OptIn(JsInternalApi::class)
inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue, Result : JsValue> JsResultLambda5.Companion.syntax(
    value: String,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false
): JsResultLambda5<Param1, Param2, Param3, Param4, Param5, Result> = JsResultLambda5Syntax(
    value = value,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable) },
    isNullable = isNullable,
)

@OptIn(JsInternalApi::class)
inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue, reified Result : JsValue> JsResultLambda5.Companion.syntax(
    value: JsElement,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false
): JsResultLambda5<Param1, Param2, Param3, Param4, Param5, Result> = JsResultLambda5Syntax(
    value = value,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable) },
    isNullable = isNullable,
)