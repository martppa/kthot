package net.asere.kotlin.js.dsl.type.lambda.l5

import net.asere.kotlin.js.dsl.JsNothing
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.async.JsAsyncSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.promise.JsPromise
import net.asere.kotlin.js.dsl.type.promise.syntax
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsDsl
fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, Param2Ref : JsReference<Param2>, Param2 : JsValue, Param3Ref : JsReference<Param3>, Param3 : JsValue, Param4Ref : JsReference<Param4>, Param4 : JsValue, Param5Ref : JsReference<Param5>, Param5 : JsValue> JsScope.Async(
    block: JsScope.() -> JsLambda5Value<Param1Ref, Param1, Param2Ref, Param2, Param3Ref, Param3, Param4Ref, Param4, Param5Ref, Param5>
): JsResultLambda5<Param1, Param2, Param3, Param4, Param5, JsPromise<JsNothing>> {
    val scope = JsSyntaxScope()
    val value = block(scope)
    return JsResultLambda5.syntax<Param1, Param2, Param3, Param4, Param5, JsPromise<JsNothing>>(
        value = JsAsyncSyntax(value = value),
        isNullable = false
    )
}

@JsDsl
inline fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, Param2Ref : JsReference<Param2>, Param2 : JsValue, Param3Ref : JsReference<Param3>, Param3 : JsValue, Param4Ref : JsReference<Param4>, Param4 : JsValue, Param5Ref : JsReference<Param5>, Param5 : JsValue, reified Result : JsValue> JsScope.AsyncResult(
    block: JsScope.() -> JsResultLambda5Value<Param1Ref, Param1, Param2Ref, Param2, Param3Ref, Param3, Param4Ref, Param4, Param5Ref, Param5, Result>
): JsResultLambda5<Param1, Param2, Param3, Param4, Param5, JsPromise<Result>> {
    val scope = JsSyntaxScope()
    val value = block(scope)
    return JsResultLambda5.syntax<Param1, Param2, Param3, Param4, Param5, JsPromise<Result>>(
        value = JsAsyncSyntax(value = value),
        resultTypeBuilder = { element, isNullable -> JsPromise.syntax(element, isNullable) },
        isNullable = false
    )
}

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