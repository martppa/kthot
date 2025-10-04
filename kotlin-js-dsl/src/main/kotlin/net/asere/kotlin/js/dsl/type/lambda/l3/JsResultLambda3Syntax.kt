package net.asere.kotlin.js.dsl.type.lambda.l3

import net.asere.kotlin.js.dsl.annotation.JsInternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsResultLambda3Syntax<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Result : JsValue> @JsInternalApi constructor(
    value: String,
    private val resultTypeBuilder: (JsElement) -> Result,
    isNullable: Boolean
) : JsReferenceSyntax<JsLambda3<Param1, Param2, Param3>>(value, isNullable), JsResultLambda3<Param1, Param2, Param3, Result> {

    @JsInternalApi constructor(
        value: JsElement,
        resultTypeBuilder: (JsElement) -> Result,
        isNullable: Boolean
    ) : this("$value", resultTypeBuilder, isNullable)

    override fun invoke(param1: Param1, param2: Param2, param3: Param3): Result =
        resultTypeBuilder(InvocationOperation(this, param1, param2, param3))
}

@OptIn(JsInternalApi::class)
inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, reified Result : JsValue> JsResultLambda3.Companion.syntax(
    value: String,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false
): JsResultLambda3<Param1, Param2, Param3, Result> = JsResultLambda3Syntax(
    value = value,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable) },
    isNullable = isNullable,
)

@OptIn(JsInternalApi::class)
inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, reified Result : JsValue> JsResultLambda3.Companion.syntax(
    value: JsElement,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false
): JsResultLambda3<Param1, Param2, Param3, Result> = JsResultLambda3Syntax(
    value = value,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable) },
    isNullable = isNullable,
)