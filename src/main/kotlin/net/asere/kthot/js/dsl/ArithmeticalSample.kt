package net.asere.kthot.js.dsl

import net.asere.kthot.js.dsl.declaration.DeclarationType
import net.asere.kthot.js.dsl.ksp.KotlinJsl
import net.asere.kthot.js.dsl.log.Console
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.def
import net.asere.kthot.js.dsl.type.number.js
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.def
import net.asere.kthot.js.dsl.type.string.js

fun main(vararg args: String) {
    KotlinJsl.initialize()
    val syntax = js {
        val result = +JsNumber.def("result").declare(DeclarationType.CONST).assignValue((5.js - 3.js) * (10.js + 2.js))
        val text = +JsString.def("text").declare(DeclarationType.CONST).assignValue("The result is: ".js + result)
        +Console.log(text)
    }
    println(syntax)
}