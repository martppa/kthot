package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.operation.or
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.type.array.def
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.def
import net.asere.kotlin.js.dsl.type.bool.js

fun main(vararg args: String) {
    val syntax = js {
        val result = +JsBoolean.def("logical").declare(Const).assign(true.js or false.js)
        Log(result)
    }
    println(syntax)
}