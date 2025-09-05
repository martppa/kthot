package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.declaration.Let
import net.asere.kotlin.js.dsl.html.jslScript
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.loop.jswhile.While
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.lt
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation.postInc
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.def
import net.asere.kotlin.js.dsl.type.number.js

fun main(vararg args: String) {
    val result = createHTML().body {
        jslScript {
            val counter = Let { JsNumber.def("counter") } assign 0
            While(counter lt 5.js) {
                +counter.postInc()
                Log(counter)
            }


        }
    }
    println(result)
}