package net.asere.kthot.js.dsl.type.lambda.l3

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.lambda.JsLambdaRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda3Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Result : JsValue>(
    name: String,
    internal val resultTypeBuilder: (JsElement) -> Result,
    isNullable: Boolean = false,
) : JsLambdaRef<JsResultLambda3<Param1, Param2, Param3, Result>>(name, isNullable), JsResultLambda3<Param1, Param2, Param3, Result> {

    override fun invoke(param1: Param1, param2: Param2, param3: Param3): Result = resultTypeBuilder(InvocationOperation(this))
}

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, reified Result : JsValue> JsResultLambda3.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda3Ref<Param1, Param2, Param3, Result> = JsResultLambda3Ref(
    name = name,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
    isNullable = isNullable
)

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, reified Result : JsValue> JsResultLambda3.Companion.ref(
    element: JsElement,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda3Ref<Param1, Param2, Param3, Result> = JsResultLambda3Ref(
    name = element.present(),
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
    isNullable = isNullable
)

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, reified Result : JsValue> JsLambda3.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
) = object : JsPrintableDefinition<JsResultLambda3Ref<Param1, Param2, Param3, Result>, JsResultLambda3<Param1, Param2, Param3, Result>>() {
    override val reference: JsResultLambda3Ref<Param1, Param2, Param3, Result> = JsResultLambda3Ref(
        name = name,
        resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
        isNullable = isNullable
    )
}