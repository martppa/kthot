package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.callable.Function
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.types.reference.lambda.ref
import net.asere.kotlin.js.dsl.syntax.operation.plus
import net.asere.kotlin.js.dsl.types.type.JsString
import net.asere.kotlin.js.dsl.types.value.value

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val simpleFunction = Function {
                Log("We called the function!")
            }
            +simpleFunction()

            val word1 = Const { JsString.ref("word1") } `=` JsString.value("Hello ")
            val word2 = Const { JsString.ref("word2") } `=` JsString.value("World")
            val greet = Function(name = "greet", JsString.ref(), JsString.ref()) { pWord1, pWord2 ->
                Log(pWord1 + pWord2)
            }
            +greet(word1, word2)
        }
    }
    println(result)
}