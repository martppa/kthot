package net.asere.kotlin.js.dsl.types.value

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.types.type.JsError
import net.asere.kotlin.js.dsl.types.type.JsPromise
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda2

class JsPromiseValue<T : JsValue> internal constructor(
    val value: JsSyntax
) : JsPromise<T>, JsRawValue<JsPromise<T>> {

    override fun present(): String = """
        $value
    """.trimIndent()

    override fun toString(): String = present()
}

fun <T : JsValue> jsPromise(
    lambda: JsLambda2<JsLambda1<T>, JsLambda1<JsError>>,
): JsPromiseValue<T> {
    return JsPromiseValue(
        JsSyntax("Promise($lambda)")
    )
}