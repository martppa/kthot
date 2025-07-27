package net.asere.kotlin.js.dsl.types.reference.lambda

import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.value.lambda.JsLambdaValue
import net.asere.kotlin.js.dsl.syntax.JsSyntax

fun JsLambdaValue.Companion.ref(name: String = "lambda_${JsReference.nextRefInt()}") = JsLambdaRef(name)

class JsLambdaRef(
    name: String,
    isNullable: Boolean = false
) : JsLambdaRefCommons<JsLambdaRef>(name, isNullable) {

    operator fun invoke() = JsSyntax("$this()")
}