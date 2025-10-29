package net.asere.kthot.js.dsl.type.lambda.l2

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.syntax
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

inline fun <Param1 : JsValue, Param2 : JsValue, reified Result : JsValue> JsResultLambda2.Companion.asyncRef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda2<Param1, Param2, JsPromise<Result>> = JsResultLambda2Ref(
    name = name,
    resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element)) },
)

inline fun <Param1 : JsValue, Param2 : JsValue, reified Result : JsValue> JsResultLambda2.Companion.asyncDef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
) = object :
    JsPrintableDefinition<JsResultLambda2Ref<Param1, Param2, JsPromise<Result>>, JsResultLambda2<Param1, Param2, JsPromise<Result>>>() {
    override val reference: JsResultLambda2Ref<Param1, Param2, JsPromise<Result>> = JsResultLambda2Ref(
        name = name,
        resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element)) },
    )
}