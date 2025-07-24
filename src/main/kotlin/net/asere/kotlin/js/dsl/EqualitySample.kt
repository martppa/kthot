package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.log.Console
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.syntax.operation.eq
import net.asere.kotlin.js.dsl.types.reference.def
import net.asere.kotlin.js.dsl.types.type.JsBoolean
import net.asere.kotlin.js.dsl.types.type.js

fun main(vararg args: String) {
    val syntax = js {
        val result = +JsBoolean.def("result").declare(Const).assign(5.js eq 5.js)
        +Console.log(result)
    }
    println(syntax)
}