package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.type.function.Function
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.syntax.operation.plus
import net.asere.kotlin.js.dsl.type.array.def
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.array.value

fun main(vararg args: String) {
    val syntax = js {
        val greet = Function(name = "greet", JsString.def(), JsString.def()) { string1, string2 ->
            Log(string1 + string2)
        }
        +greet(value("Hello, "), value("World"))
    }
    println(syntax)
}