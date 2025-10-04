@file:OptIn(JsInternalApi::class)

package net.asere.kotlin.js.dsl.type.promise

import net.asere.kotlin.js.dsl.annotation.JsInternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.instantiation.JsInstantiationSyntax
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.error.JsError
import net.asere.kotlin.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kotlin.js.dsl.type.lambda.l1.JsLambda1Ref
import net.asere.kotlin.js.dsl.type.lambda.l1.ref
import net.asere.kotlin.js.dsl.type.lambda.l2.JsLambda2
import net.asere.kotlin.js.dsl.type.value.JsRawValue
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsInternalApi
class JsPromiseValue<T : JsValue>(
    val value: JsSyntax,
    override val typeBuilder: (JsElement, Boolean) -> T,
) : JsPromise<T>, JsRawValue<JsPromise<T>> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

fun <T : JsValue> JsPromise.Companion.value(
    lambda: JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
    typeBuilder: (JsElement, Boolean) -> T
): JsPromise<T> {
    return JsPromiseValue(
        value = JsSyntax("Promise($lambda)"),
        typeBuilder = typeBuilder
    )
}

inline fun <reified T : JsValue> JsPromise.Companion.value(
    lambda: JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
): JsPromise<T> {
    return JsPromiseValue(
        value = JsSyntax("Promise($lambda)"),
        typeBuilder = ::provide
    )
}

inline fun <reified T : JsValue> JsPromise.Companion.value(
    value: JsSyntax,
): JsPromiseValue<T> {
    return JsPromiseValue(
        value = JsSyntax("Promise($value)"),
        typeBuilder = ::provide
    )
}

fun <T : JsValue> JsPromise.Companion.new(
    typeBuilder: (JsElement, Boolean) -> T,
    block: () -> JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
): JsPromise<T> {
    return JsPromise.syntax(
        value = JsInstantiationSyntax(
            value = JsPromise.value(
                lambda = block(),
                typeBuilder = typeBuilder
            )
        ),
        typeBuilder = typeBuilder
    )
}

inline fun <reified T : JsValue> JsPromise.Companion.new(
    lambda: JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
): JsPromise<T> = JsPromise.syntax(
    value = JsInstantiationSyntax(JsPromise.value(lambda)),
    typeBuilder = ::provide
)

inline fun <reified T : JsValue> JsPromise.Companion.new(
    block: JsScope.(JsLambda1Ref<T>, JsLambda1Ref<JsError>) -> Unit,
): JsPromise<T> {
    val scope = JsSyntaxScope()
    val onSuccessLambda = JsLambda1.ref<T>("onSuccess")
    val onErrorLambda = JsLambda1.ref<JsError>("onError")
    block(scope, onSuccessLambda, onErrorLambda)
    val syntax = JsSyntax("($onSuccessLambda, $onErrorLambda) => {\n    $scope\n}")
    return JsPromise.syntax(
        value = JsInstantiationSyntax(JsPromise.value<T>(value = syntax)),
        typeBuilder = ::provide
    )
}