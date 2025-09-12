package net.asere.kotlin.js.dsl.type.lambda.l1

import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsResultLambda1Ref<Param1 : JsValue, Result : JsValue>(
    name: String,
    private val resultTypeBuilder: (JsElement) -> Result,
    isNullable: Boolean = false,
) : JsLambdaRef<JsResultLambda1<Param1, Result>>(name, isNullable), JsResultLambda1<Param1, Result> {

    override fun invoke(param: Param1): Result = resultTypeBuilder(InvocationOperation(this))
}

inline fun <Param1 : JsValue, reified Result : JsValue> JsResultLambda1.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda1Ref<Param1, Result> = JsResultLambda1Ref(
    name = name,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
    isNullable = isNullable
)

inline fun <Param1 : JsValue, reified Result : JsValue> JsLambda1.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
) = object : JsPrintableDefinition<JsResultLambda1Ref<Param1, Result>, JsResultLambda1<Param1, Result>>() {
    override val reference: JsResultLambda1Ref<Param1, Result> = JsResultLambda1Ref(
        name = name,
        resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
        isNullable = isNullable
    )
}