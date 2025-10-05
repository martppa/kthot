package net.asere.kthot.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.html.jslScript
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.type.function.Function
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.def
import net.asere.kthot.js.dsl.type.string.js

fun main(vararg args: String) {
    val result = createHTML().body {
        jslScript {
            val simpleFunction = Function {
                Log("We called the function!")
            }
            +simpleFunction()

            val word1 = Const { JsString.def("word1") } assign "Hello ".js
            val word2 = Const { JsString.def("word2") } assign "World".js
            val greet = Function(name = "greet", JsString.def(), JsString.def()) { pWord1, pWord2 ->
                Log(pWord1 + pWord2)
            }
            +greet(word1, word2)
        }
    }
    println(result)
}