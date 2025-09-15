package net.asere.kotlin.js.dsl.type.promise

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.instantiation.JsInstantiationSyntax
import net.asere.kotlin.js.dsl.type.error.JsError
import net.asere.kotlin.js.dsl.type.lambda.jsLambda
import net.asere.kotlin.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kotlin.js.dsl.type.lambda.l1.def
import net.asere.kotlin.js.dsl.type.lambda.l2.JsLambda2
import net.asere.kotlin.js.dsl.type.value.JsRawValue
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsPromiseValue<T : JsValue> internal constructor(
    val value: JsSyntax
) : JsPromise<T>, JsRawValue<JsPromise<T>> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

fun <T : JsValue> JsPromise.Companion.value(
    lambda: JsLambda2<JsLambda1<T>, JsLambda1<JsError>>
) = jsPromise(lambda)

fun <T : JsValue> jsPromise(
    lambda: JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
): JsPromiseValue<T> {
    return JsPromiseValue(
        JsSyntax("Promise($lambda)")
    )
}

fun <T : JsValue> JsPromise.Companion.new(block: () -> JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
): JsPromise<T> {
    return JsPromise.syntax(
        JsInstantiationSyntax(JsPromiseValue<T>(JsSyntax("Promise(${block()}")))
    )
}