package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.types.type.function.Function
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.syntax.operation.plus
import net.asere.kotlin.js.dsl.types.reference.def
import net.asere.kotlin.js.dsl.types.type.JsString
import net.asere.kotlin.js.dsl.types.value.value

fun main(vararg args: String) {
    val syntax = js {
        val greet = Function(name = "greet", JsString.def(), JsString.def()) { string1, string2 ->
            Log(string1 + string2)
        }
        +greet(JsString.value("Hello, "), JsString.value("World"))
    }
    println(syntax)
}