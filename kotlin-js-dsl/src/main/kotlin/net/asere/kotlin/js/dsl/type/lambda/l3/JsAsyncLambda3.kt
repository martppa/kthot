package net.asere.kotlin.js.dsl.type.lambda.l3

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
fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, Param2Ref : JsReference<Param2>, Param2 : JsValue, Param3Ref : JsReference<Param3>, Param3 : JsValue> JsScope.Async(
    block: JsScope.() -> JsLambda3Value<Param1Ref, Param1, Param2Ref, Param2, Param3Ref, Param3>
): JsResultLambda3<Param1, Param2, Param3, JsPromise<JsNothing>> {
    val scope = JsSyntaxScope()
    val value = block(scope)
    return JsResultLambda3.syntax<Param1, Param2, Param3, JsPromise<JsNothing>>(
        value = JsAsyncSyntax(value = value),
        isNullable = false
    )
}

@JsDsl
inline fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, Param2Ref : JsReference<Param2>, Param2 : JsValue, Param3Ref : JsReference<Param3>, Param3 : JsValue, reified Result : JsValue> JsScope.AsyncResult(
    block: JsScope.() -> JsResultLambda3Value<Param1Ref, Param1, Param2Ref, Param2, Param3Ref, Param3, Result>
): JsResultLambda3<Param1, Param2, Param3, JsPromise<Result>> {
    val scope = JsSyntaxScope()
    val value = block(scope)
    return JsResultLambda3.syntax<Param1, Param2, Param3, JsPromise<Result>>(
        value = JsAsyncSyntax(value = value),
        resultTypeBuilder = { element, isNullable -> JsPromise.syntax(element, isNullable) },
        isNullable = false
    )
}

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, reified Result : JsValue> JsResultLambda3.Companion.asyncRef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda3<Param1, Param2, Param3, JsPromise<Result>> = JsResultLambda3Ref(
    name = name,
    resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element, isResultNullable)) },
    isNullable = isNullable
)

inline fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, reified Result : JsValue> JsResultLambda3.Companion.asyncDef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
) = object :
    JsPrintableDefinition<JsResultLambda3Ref<Param1, Param2, Param3, JsPromise<Result>>, JsResultLambda3<Param1, Param2, Param3, JsPromise<Result>>>() {
    override val reference: JsResultLambda3Ref<Param1, Param2, Param3, JsPromise<Result>> = JsResultLambda3Ref(
        name = name,
        resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element, isResultNullable)) },
        isNullable = isNullable
    )
}