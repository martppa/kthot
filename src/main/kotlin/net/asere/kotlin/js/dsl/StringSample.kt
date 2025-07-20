package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.callable.JsFunction
import net.asere.kotlin.js.dsl.log.jsLog
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.syntax.operation.plus
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.value.value

fun main(vararg args: String) {
    val syntax = js {
        val greet = +JsFunction(name = "greet", JsString.ref(), JsString.ref()) { string1, string2 ->
            +jsLog(string1 + string2)
        }
        +greet(JsString.value("Hello, "), JsString.value("World"))
    }
    println(syntax)
}