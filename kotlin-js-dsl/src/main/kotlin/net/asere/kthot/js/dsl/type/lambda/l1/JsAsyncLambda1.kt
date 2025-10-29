package net.asere.kthot.js.dsl.type.lambda.l1

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.syntax
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

inline fun <Param1 : JsValue, reified Result : JsValue> JsResultLambda1.Companion.asyncRef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda1<Param1, JsPromise<Result>> = JsResultLambda1Ref(
    name = name,
    resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element))},
)

inline fun <Param1 : JsValue, reified Result : JsValue> JsResultLambda1.Companion.asyncDef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
) = object : JsPrintableDefinition<JsResultLambda1Ref<Param1, JsPromise<Result>>, JsResultLambda1<Param1, JsPromise<Result>>>() {
    override val reference: JsResultLambda1Ref<Param1, JsPromise<Result>> = JsResultLambda1Ref(
        name = name,
        resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element))},
    )
}