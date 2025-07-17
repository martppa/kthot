package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.callable.JsFunction
import net.asere.kotlin.js.dsl.callable.JsLambda
import net.asere.kotlin.js.dsl.callable.value
import net.asere.kotlin.js.dsl.declaration.Constant
import net.asere.kotlin.js.dsl.declaration.Mutable
import net.asere.kotlin.js.dsl.log.jsLog
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.syntax.jsReturn
import net.asere.kotlin.js.dsl.type.JsCollection
import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.type.JsObject
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.value.plus
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