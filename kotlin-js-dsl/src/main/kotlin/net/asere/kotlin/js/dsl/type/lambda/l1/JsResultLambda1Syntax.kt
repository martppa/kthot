package net.asere.kotlin.js.dsl.type.lambda.l1

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsResultLambda1Syntax<Param1 : JsValue, Result : JsValue> @InternalApi constructor(
    value: String,
    private val resultTypeBuilder: (JsElement) -> Result,
    isNullable: Boolean
) : JsReferenceSyntax<JsLambda1<Param1>>(value, isNullable), JsResultLambda1<Param1, Result> {
    @InternalApi constructor(
        value: JsElement,
        resultTypeBuilder: (JsElement) -> Result,
        isNullable: Boolean
    ) : this("$value", resultTypeBuilder, isNullable)

    override fun invoke(param: Param1): Result = resultTypeBuilder(InvocationOperation(this, param))
}

@OptIn(InternalApi::class)
inline fun <Param1 : JsValue, Result : JsValue> JsLambda1.Companion.syntax(
    value: String,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false
): JsResultLambda1<Param1, Result> = JsResultLambda1Syntax(
    value = value,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable) },
    isNullable = isNullable,
)

@OptIn(InternalApi::class)
inline fun <Param1 : JsValue, Result : JsValue> JsLambda1.Companion.syntax(
    value: JsElement,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false
): JsResultLambda1<Param1, Result> = JsResultLambda1Syntax(
    value = value,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable) },
    isNullable = isNullable,
)