package net.asere.kotlin.js.dsl.type.lambda.l0

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
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsDsl
fun JsScope.Async(block: JsScope.() -> JsLambda0Value): JsResultLambda0<JsPromise<JsNothing>> {
    val scope = JsSyntaxScope()
    val value = block(scope)
    return JsResultLambda0.syntax<JsPromise<JsNothing>>(JsAsyncSyntax(value = value), isNullable = false)
}

@JsDsl
inline fun <reified Result : JsValue> JsScope.AsyncResult(
    block: JsScope.() -> JsResultLambda0Value<Result>
): JsResultLambda0<JsPromise<Result>> {
    val scope = JsSyntaxScope()
    val value = block(scope)
    return JsResultLambda0.syntax<JsPromise<Result>>(
        value = JsAsyncSyntax(value = value),
        resultTypeBuilder = { element, isNullable ->
            JsPromise.syntax(element, isNullable)
        },
        isNullable = false)
}

inline fun <reified Result : JsValue> JsResultLambda0.Companion.asyncRef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
): JsResultLambda0<JsPromise<Result>> = JsResultLambda0Ref(
    name = name,
    resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element, isResultNullable))},
    isNullable = isNullable
)

inline fun <reified Result : JsValue> JsResultLambda0.Companion.asyncDef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    isNullable: Boolean = false,
    isResultNullable: Boolean = false,
) = object : JsPrintableDefinition<JsResultLambda0Ref<JsPromise<Result>>, JsResultLambda0<JsPromise<Result>>>() {
    override val reference: JsResultLambda0Ref<JsPromise<Result>> = JsResultLambda0Ref(
        name = name,
        resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element, isResultNullable))},
        isNullable = isNullable
    )
}