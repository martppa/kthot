package net.asere.kotlin.js.dsl.type.lambda.l2

import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.promise.JsPromise
import net.asere.kotlin.js.dsl.type.promise.syntax
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

inline fun <Param1 : JsValue, Param2 : JsValue, reified Result : JsValue> JsResultLambda2.Companion.asyncRef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda2<Param1, Param2, JsPromise<Result>> = JsResultLambda2Ref(
    name = name,
    resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element, isResultNullable)) },
    isNullable = isNullable
)

inline fun <Param1 : JsValue, Param2 : JsValue, reified Result : JsValue> JsResultLambda2.Companion.asyncDef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
) = object :
    JsPrintableDefinition<JsResultLambda2Ref<Param1, Param2, JsPromise<Result>>, JsResultLambda2<Param1, Param2, JsPromise<Result>>>() {
    override val reference: JsResultLambda2Ref<Param1, Param2, JsPromise<Result>> = JsResultLambda2Ref(
        name = name,
        resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element, isResultNullable)) },
        isNullable = isNullable
    )
}