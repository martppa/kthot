package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.declaration.Constant
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.jsLog
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.jsif.jsElse
import net.asere.kotlin.js.dsl.syntax.jsif.jsElseIf
import net.asere.kotlin.js.dsl.syntax.jsif.jsIf
import net.asere.kotlin.js.dsl.syntax.loop.jsfor.forI
import net.asere.kotlin.js.dsl.syntax.loop.jsfor.jsFor
import net.asere.kotlin.js.dsl.syntax.operation.*
import net.asere.kotlin.js.dsl.type.JsBoolean
import net.asere.kotlin.js.dsl.type.js

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            +jsFor(forI, 0.js, forI < 10, forI.postInc()) {

            }
        }
    }
    println(result)
}