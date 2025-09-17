package net.asere.kotlin.js.dsl.type.lambda.l5

import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.promise.JsPromise
import net.asere.kotlin.js.dsl.type.promise.syntax
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue, reified Result : JsValue> JsResultLambda5.Companion.asyncRef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda5<Param1, Param2, Param3, Param4, Param5, JsPromise<Result>> = JsResultLambda5Ref(
    name = name,
    resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element, isResultNullable)) },
    isNullable = isNullable
)

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue, reified Result : JsValue> JsResultLambda5.Companion.asyncDef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
) = object :
    JsPrintableDefinition<JsResultLambda5Ref<Param1, Param2, Param3, Param4, Param5, JsPromise<Result>>, JsResultLambda5<Param1, Param2, Param3, Param4, Param5, JsPromise<Result>>>() {
    override val reference: JsResultLambda5Ref<Param1, Param2, Param3, Param4, Param5, JsPromise<Result>> = JsResultLambda5Ref(
        name = name,
        resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element, isResultNullable)) },
        isNullable = isNullable
    )
}