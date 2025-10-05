package net.asere.kthot.js.dsl

import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.type.function.Function
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.def
import net.asere.kthot.js.dsl.type.string.value

fun main(vararg args: String) {
    val syntax = js {
        val greet = Function(name = "greet", JsString.def(), JsString.def()) { string1, string2 ->
            Log(string1 + string2)
        }
        +greet(JsString.value("Hello, "), JsString.value("World"))
    }
    println(syntax)
}