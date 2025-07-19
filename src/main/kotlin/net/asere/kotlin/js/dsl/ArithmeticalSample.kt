package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Constant
import net.asere.kotlin.js.dsl.log.jsLog
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.type.js
import net.asere.kotlin.js.dsl.value.minus
import net.asere.kotlin.js.dsl.value.plus

fun main(vararg args: String) {
    val syntax = js {
        val result = +JsNumber.ref("result").declare(Constant).assign(5.js + 10.js - 2.js)
        val text = +JsString.ref("text").declare(Constant).assign("The result is: ".js + result)
        +jsLog(text)
    }
    println(syntax)
}