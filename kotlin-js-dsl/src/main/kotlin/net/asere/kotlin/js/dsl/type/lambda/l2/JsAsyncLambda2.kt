package net.asere.kotlin.js.dsl.type.lambda.l2

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
fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, Param2Ref : JsReference<Param2>, Param2 : JsValue> JsScope.Async(
    block: JsScope.() -> JsLambda2Value<Param1Ref, Param1, Param2Ref, Param2>
): JsResultLambda2<Param1, Param2, JsPromise<JsNothing>> {
    val scope = JsSyntaxScope()
    val value = block(scope)
    return JsResultLambda2.syntax<Param1, Param2, JsPromise<JsNothing>>(
        value = JsAsyncSyntax(value = value),
        isNullable = false
    )
}

@JsDsl
inline fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, Param2Ref : JsReference<Param2>, Param2 : JsValue, reified Result : JsValue> JsScope.AsyncResult(
    block: JsScope.() -> JsResultLambda2Value<Param1Ref, Param1, Param2Ref, Param2, Result>
): JsResultLambda2<Param1, Param2, JsPromise<Result>> {
    val scope = JsSyntaxScope()
    val value = block(scope)
    return JsResultLambda2.syntax<Param1, Param2, JsPromise<Result>>(
        value = JsAsyncSyntax(value = value),
        resultTypeBuilder = { element, isNullable -> JsPromise.syntax(element, isNullable) },
        isNullable = false
    )
}

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