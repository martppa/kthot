package net.asere.kthot.js.dsl.sample.snippets

import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.declaration.DeclarationType
import net.asere.kthot.js.dsl.log.Console
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison.lt
import net.asere.kthot.js.dsl.syntax.operational.equality.comparison.eq
import net.asere.kthot.js.dsl.syntax.operational.logical.comparison.and
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.def
import net.asere.kthot.js.dsl.type.number.js

fun main(vararg args: String) {
    val syntax = js {
        val result = Const { JsBoolean.def("result") } assign (1.js eq (0.js and (2.js lt 20.js)))
        +Console.log(result)
    }
    println(syntax)
}