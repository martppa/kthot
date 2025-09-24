package net.asere.kotlin.js.dsl.type.lambda.l4

import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsResultLambda4Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Result : JsValue>(
    name: String,
    internal val resultTypeBuilder: (JsElement) -> Result,
    isNullable: Boolean = false,
) : JsLambdaRef<JsResultLambda4<Param1, Param2, Param3, Param4, Result>>(name, isNullable), JsResultLambda4<Param1, Param2, Param3, Param4, Result> {

    override fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4): Result = resultTypeBuilder(InvocationOperation(this))
}

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, reified Result : JsValue> JsResultLambda4.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda4Ref<Param1, Param2, Param3, Param4, Result> = JsResultLambda4Ref(
    name = name,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
    isNullable = isNullable
)

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, reified Result : JsValue> JsResultLambda4.Companion.ref(
    element: JsElement,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda4Ref<Param1, Param2, Param3, Param4, Result> = JsResultLambda4Ref(
    name = element.present(),
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
    isNullable = isNullable
)

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, reified Result : JsValue> JsLambda4.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
) = object : JsPrintableDefinition<JsResultLambda4Ref<Param1, Param2, Param3, Param4, Result>, JsResultLambda4<Param1, Param2, Param3, Param4, Result>>() {
    override val reference: JsResultLambda4Ref<Param1, Param2, Param3, Param4, Result> = JsResultLambda4Ref(
        name = name,
        resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
        isNullable = isNullable
    )
}