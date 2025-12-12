@file:OptIn(JsInternalApi::class)

package net.asere.kthot.js.dsl.type.promise

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.syntax.operational.instantiation.InstantiationOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.error.JsError
import net.asere.kthot.js.dsl.type.lambda.jsLambda
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1Ref
import net.asere.kthot.js.dsl.type.lambda.l1.def
import net.asere.kthot.js.dsl.type.lambda.l1.ref
import net.asere.kthot.js.dsl.type.lambda.l2.JsLambda2
import net.asere.kthot.js.dsl.type.lambda.l2.JsLambda2Ref
import net.asere.kthot.js.dsl.type.lambda.l2.JsLambda2Value
import net.asere.kthot.js.dsl.type.value.JsRawValue
import net.asere.kthot.js.dsl.type.value.JsValue

@JsInternalApi
class JsPromiseValue<T : JsValue>(
    val value: JsSyntax,
    override val _typeBuilder_: (JsElement) -> T,
) : JsPromise<T>, JsRawValue<JsPromise<T>> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

fun <T : JsValue> JsPromise.Companion.value(
    lambda: JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
    typeBuilder: (JsElement) -> T
): JsPromise<T> {
    return JsPromiseValue(
        value = JsSyntax("Promise($lambda)"),
        _typeBuilder_ = typeBuilder
    )
}

inline fun <reified T : JsValue> JsPromise.Companion.value(
    lambda: JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
): JsPromise<T> {
    return JsPromiseValue(
        value = JsSyntax("Promise($lambda)"),
        _typeBuilder_ = ::provide
    )
}

inline fun <reified T : JsValue> JsPromise.Companion.value(
    value: JsSyntax,
): JsPromiseValue<T> {
    return JsPromiseValue(
        value = JsSyntax("Promise($value)"),
        _typeBuilder_ = ::provide
    )
}

fun <T : JsValue> JsPromise.Companion.new(
    typeBuilder: (JsElement) -> T,
    block: () -> JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
): JsPromise<T> {
    return JsPromise.syntax(
        value = InstantiationOperation(
            value = InvocationOperation(leftSideElement = "Promise", block())
        ),
        typeBuilder = typeBuilder
    )
}

inline fun <reified T : JsValue> JsPromise.Companion.new(
    lambda: JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
): JsPromise<T> = JsPromise.syntax(
    value = InstantiationOperation(InvocationOperation(leftSideElement = "Promise", lambda)),
    typeBuilder = ::provide
)

inline fun <reified T : JsValue> JsPromise.Companion.new(
    noinline block: JsScope.(JsLambda1Ref<T>, JsLambda1Ref<JsError>) -> Unit,
): JsPromise<T> {
    val onSuccessLambda = JsLambda1.def<T>("onSuccess")
    val onErrorLambda = JsLambda1.def<JsError>("onError")
    val lambda = jsLambda(
        param1 = onSuccessLambda,
        param2 = onErrorLambda,
        definition = block
    )
    return JsPromise.syntax(
        value = InstantiationOperation(InvocationOperation("Promise", lambda)),
        typeBuilder = ::provide
    )
}