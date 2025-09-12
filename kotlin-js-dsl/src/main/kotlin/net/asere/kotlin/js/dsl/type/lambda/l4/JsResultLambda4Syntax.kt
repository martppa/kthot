package net.asere.kotlin.js.dsl.type.lambda.l4

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsResultLambda4Syntax<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Result : JsValue> @InternalApi constructor(
    value: String,
    private val resultTypeBuilder: (JsElement) -> Result,
    isNullable: Boolean
) : JsReferenceSyntax<JsLambda4<Param1, Param2, Param3, Param4>>(value, isNullable), JsResultLambda4<Param1, Param2, Param3, Param4, Result> {

    @InternalApi constructor(
        value: JsElement,
        resultTypeBuilder: (JsElement) -> Result,
        isNullable: Boolean
    ) : this("$value", resultTypeBuilder, isNullable)

    override fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4): Result =
        resultTypeBuilder(InvocationOperation(this, param1, param2, param3, param4))
}

@OptIn(InternalApi::class)
inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Result : JsValue> JsLambda4.Companion.syntax(
    value: String,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false
): JsResultLambda4<Param1, Param2, Param3, Param4, Result> = JsResultLambda4Syntax(
    value = value,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable) },
    isNullable = isNullable,
)

@OptIn(InternalApi::class)
inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Result : JsValue> JsLambda4.Companion.syntax(
    value: JsElement,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false
): JsResultLambda4<Param1, Param2, Param3, Param4, Result> = JsResultLambda4Syntax(
    value = value,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable) },
    isNullable = isNullable,
)