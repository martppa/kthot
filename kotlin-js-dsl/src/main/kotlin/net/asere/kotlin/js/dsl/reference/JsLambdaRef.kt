package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.value.JsLambdaValue
import net.asere.kotlin.js.dsl.syntax.JsSyntax

fun JsLambdaValue.Companion.ref(name: String = "lambda_${JsReference.nextRefInt()}") = JsLambdaRef(name)

class JsLambdaRef(
    name: String
) : JsLambdaRefCommons<JsLambdaRef>(name) {

    operator fun invoke() = JsSyntax("$this()")
}