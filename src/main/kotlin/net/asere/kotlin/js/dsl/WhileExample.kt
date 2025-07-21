package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.declaration.Let
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.loop.jsfor.For
import net.asere.kotlin.js.dsl.log.Console
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.loop.jswhile.While
import net.asere.kotlin.js.dsl.syntax.operation.*
import net.asere.kotlin.js.dsl.type.*
import net.asere.kotlin.js.dsl.value.get
import net.asere.kotlin.js.dsl.value.value

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val counter = Let { JsNumber.ref("counter") } `=` 0
            While(counter lt 5.js) {
                counter.postInc()
                Log(counter)
            }


        }
    }
    println(result)
}