package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.callable.JsLambda
import net.asere.kotlin.js.dsl.callable.JsLambda2
import net.asere.kotlin.js.dsl.callable.value
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.jsLog
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.jsReturn
import net.asere.kotlin.js.dsl.syntax.operation.plus
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.value.value

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val lambda = JsLambda.value(
                JsString.ref("first"),
                JsString.ref("second")
            ) { first, second ->
                +jsReturn(first + second)
            }
            val lambdaRef = +JsLambda2.ref<JsString, JsString>("lambda")
                .declare(Const)
                .assign(lambda)
            val concatenation = +JsString
                .ref("concatenation")
                .declare(Const)
                .assign(lambdaRef(JsString.value("Hello "), JsString.value("World")))
            +jsLog(concatenation)
        }
    }
    println(result)
}