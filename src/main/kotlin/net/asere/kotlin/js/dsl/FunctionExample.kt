package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation.plus
import net.asere.kotlin.js.dsl.type.function.f0.Function
import net.asere.kotlin.js.dsl.type.function.f2.Function
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.def
import net.asere.kotlin.js.dsl.type.string.js

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val simpleFunction = Function {
                Log("We called the function!")
            }
            +simpleFunction()

            val word1 = Const { JsString.def("word1") } `=` "Hello ".js
            val word2 = Const { JsString.def("word2") } `=` "World".js
            val greet = Function(name = "greet", JsString.def(), JsString.def()) { pWord1, pWord2 ->
                Log(pWord1 + pWord2)
            }
            +greet(word1, word2)
        }
    }
    println(result)
}