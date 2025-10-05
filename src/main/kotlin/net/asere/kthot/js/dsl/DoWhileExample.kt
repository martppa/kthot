package net.asere.kthot.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kthot.js.dsl.declaration.Let
import net.asere.kthot.js.dsl.html.jslScript
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.syntax.loop.jswhile.DoWhile
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison.lt
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation.postInc
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.def
import net.asere.kthot.js.dsl.type.number.js

fun main(vararg args: String) {
    val result = createHTML().body {
        jslScript {
            val counter = Let { JsNumber.def("counter") } assign 0.js
            DoWhile(counter lt 5.js) {
                counter.postInc()
                Log(counter)
            }
        }
    }
    println(result)
}