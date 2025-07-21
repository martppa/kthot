package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.log.Console
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.syntax.operation.minus
import net.asere.kotlin.js.dsl.syntax.operation.plus
import net.asere.kotlin.js.dsl.syntax.operation.times
import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.type.js

fun main(vararg args: String) {
    val syntax = js {
        val result = +JsNumber.ref("result").declare(Const).assign((5.js - 3.js) * (10.js + 2.js))
        val text = +JsString.ref("text").declare(Const).assign("The result is: ".js + result)
        +Console.log(text)
    }
    println(syntax)
}