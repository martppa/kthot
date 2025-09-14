package net.asere.kotlin.js.dsl.type.lambda.l1

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
fun  <Param1Ref: JsReference<Param1>, Param1 : JsValue> JsScope.Async(
    block: JsScope.() -> JsLambda1Value<Param1Ref, Param1>
): JsResultLambda1<Param1, JsPromise<JsNothing>> {
    val scope = JsSyntaxScope()
    val value = block(scope)
    return JsResultLambda1.syntax<Param1, JsPromise<JsNothing>>(JsAsyncSyntax(value = value), isNullable = false)
}

@JsDsl
inline fun <Param1Ref: JsReference<Param1>, Param1 : JsValue, reified Result : JsValue> JsScope.AsyncResult(
    block: JsScope.() -> JsResultLambda1Value<Param1Ref, Param1, Result>
): JsResultLambda1<Param1, JsPromise<Result>> {
    val scope = JsSyntaxScope()
    val value = block(scope)
    return JsResultLambda1.syntax<Param1, JsPromise<Result>>(
        value = JsAsyncSyntax(value = value),
        resultTypeBuilder = { element, isNullable -> JsPromise.syntax(element, isNullable) },
        isNullable = false
    )
}

inline fun <Param1 : JsValue, reified Result : JsValue> JsResultLambda1.Companion.asyncRef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda1<Param1, JsPromise<Result>> = JsResultLambda1Ref(
    name = name,
    resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element, isResultNullable))},
    isNullable = isNullable
)

inline fun <Param1 : JsValue, reified Result : JsValue> JsResultLambda1.Companion.asyncDef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
) = object : JsPrintableDefinition<JsResultLambda1Ref<Param1, JsPromise<Result>>, JsResultLambda1<Param1, JsPromise<Result>>>() {
    override val reference: JsResultLambda1Ref<Param1, JsPromise<Result>> = JsResultLambda1Ref(
        name = name,
        resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element, isResultNullable))},
        isNullable = isNullable
    )
}