package net.asere.kthot.js.dsl

import net.asere.kthot.js.dsl.declaration.DeclarationType
import net.asere.kthot.js.dsl.log.Console
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.syntax.operational.equality.comparison.eq
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.def
import net.asere.kthot.js.dsl.type.number.js

fun main(vararg args: String) {
    val syntax = js {
        val result = +JsBoolean.def("result").declare(DeclarationType.CONST).assignValue(5.js eq 5.js)
        +Console.log(result)
    }
    println(syntax)
}