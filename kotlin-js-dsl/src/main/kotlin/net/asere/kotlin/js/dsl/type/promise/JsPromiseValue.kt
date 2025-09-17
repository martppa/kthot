package net.asere.kotlin.js.dsl.type.promise

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.instantiation.JsInstantiationSyntax
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.error.JsError
import net.asere.kotlin.js.dsl.type.lambda.jsLambda
import net.asere.kotlin.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kotlin.js.dsl.type.lambda.l1.def
import net.asere.kotlin.js.dsl.type.lambda.l2.JsLambda2
import net.asere.kotlin.js.dsl.type.value.JsRawValue
import net.asere.kotlin.js.dsl.type.value.JsValue

@OptIn(InternalApi::class)
class JsPromiseValue<T : JsValue> internal constructor(
    val value: JsSyntax,
    override val typeBuilder: (JsElement, Boolean) -> T
) : JsPromise<T>, JsRawValue<JsPromise<T>> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

inline fun <reified T : JsValue> JsPromise.Companion.value(
    lambda: JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
    noinline typeBuilder: (JsElement, Boolean) -> T = ::provide
) = jsPromise(lambda, typeBuilder)

fun <T : JsValue> jsPromise(
    lambda: JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
    typeBuilder: (JsElement, Boolean) -> T,
): JsPromiseValue<T> {
    return JsPromiseValue(
        value = JsSyntax("Promise($lambda)"),
        typeBuilder = typeBuilder
    )
}

inline fun <reified T : JsValue> JsPromise.Companion.new(
    block: () -> JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
): JsPromise<T> {
    return JsPromise.syntax(
        JsInstantiationSyntax(JsPromise.value<T>(block()))
    )
}