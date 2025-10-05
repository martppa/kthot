package net.asere.kthot.js.dsl

import net.asere.kthot.js.dsl.declaration.DeclarationType
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.syntax.operational.logical.comparison.or
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.def
import net.asere.kthot.js.dsl.type.bool.js

fun main(vararg args: String) {
    val syntax = js {
        val result = +JsBoolean.def("logical")
            .declare(DeclarationType.CONST)
            .assignValue(true.js or false.js)
        Log(result)
    }
    println(syntax)
}