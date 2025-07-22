package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.callable.*
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.reference.JsLambda1Ref
import net.asere.kotlin.js.dsl.reference.JsNumberRef
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.Return
import net.asere.kotlin.js.dsl.syntax.operation.plus
import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.type.js

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            Lambda {
                Log("Inside a lambda")
            }

            val sum = Const { JsLambda2.ref<JsNumber, JsNumber>() } `=` Lambda(
                JsString.ref("first"),
                JsString.ref("second")
            ) { first, second ->
                Return(first + second)
            }
            Log(sum(5.js, 4.js))

            val setOnClick = Function("setOnClick", JsLambda1.ref<JsString>("sender")) { callback ->
                callback("button".js)
            }
            setOnClick(Lambda(JsString.ref("sender")) {

            })
        }
    }
    println(result)
}