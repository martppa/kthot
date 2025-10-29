package net.asere.kthot.js.dsl.type.lambda.l4

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.syntax
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, reified Result : JsValue> JsResultLambda4.Companion.asyncRef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda4<Param1, Param2, Param3, Param4, JsPromise<Result>> = JsResultLambda4Ref(
    name = name,
    resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element)) },
)

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, reified Result : JsValue> JsResultLambda4.Companion.asyncDef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement) -> Result = ::provide,
) = object :
    JsPrintableDefinition<JsResultLambda4Ref<Param1, Param2, Param3, Param4, JsPromise<Result>>, JsResultLambda4<Param1, Param2, Param3, Param4, JsPromise<Result>>>() {
    override val reference: JsResultLambda4Ref<Param1, Param2, Param3, Param4, JsPromise<Result>> = JsResultLambda4Ref(
        name = name,
        resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element)) },
    )
}