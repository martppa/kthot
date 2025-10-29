package net.asere.kthot.js.dsl.type.lambda.l3

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.syntax
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, reified Result : JsValue> JsResultLambda3.Companion.asyncRef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda3<Param1, Param2, Param3, JsPromise<Result>> = JsResultLambda3Ref(
    name = name,
    resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element)) },
)

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, reified Result : JsValue> JsResultLambda3.Companion.asyncDef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
) = object :
    JsPrintableDefinition<JsResultLambda3Ref<Param1, Param2, Param3, JsPromise<Result>>, JsResultLambda3<Param1, Param2, Param3, JsPromise<Result>>>() {
    override val reference: JsResultLambda3Ref<Param1, Param2, Param3, JsPromise<Result>> = JsResultLambda3Ref(
        name = name,
        resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element)) },
    )
}