package net.asere.kthot.js.dsl.type.lambda.l2

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.lambda.JsLambdaRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

class JsResultLambda2Ref<Param1 : JsValue, Param2 : JsValue, Result : JsValue>(
    name: String,
    internal val resultTypeBuilder: (JsElement) -> Result,
    isNullable: Boolean = false,
) : JsLambdaRef<JsResultLambda2<Param1, Param2, Result>>(name, isNullable), JsResultLambda2<Param1, Param2, Result> {

    override fun invoke(param1: Param1, param2: Param2): Result = resultTypeBuilder(InvocationOperation(this))
}

inline fun <Param1 : JsValue, Param2 : JsValue, reified Result : JsValue> JsResultLambda2.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda2Ref<Param1, Param2, Result> = JsResultLambda2Ref(
    name = name,
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
    isNullable = isNullable
)

inline fun <Param1 : JsValue, Param2 : JsValue, reified Result : JsValue> JsResultLambda2.Companion.ref(
    element: JsElement,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda2Ref<Param1, Param2, Result> = JsResultLambda2Ref(
    name = element.present(),
    resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
    isNullable = isNullable
)

inline fun <Param1 : JsValue, Param2 : JsValue, reified Result : JsValue> JsLambda2.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
) = object : JsPrintableDefinition<JsResultLambda2Ref<Param1, Param2, Result>, JsResultLambda2<Param1, Param2, Result>>() {
    override val reference: JsResultLambda2Ref<Param1, Param2, Result> = JsResultLambda2Ref(
        name = name,
        resultTypeBuilder = { element -> resultTypeBuilder(element, isResultNullable)},
        isNullable = isNullable
    )
}