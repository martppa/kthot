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
import net.asere.kotlin.js.dsl.syntax.operation.*
import net.asere.kotlin.js.dsl.type.*
import net.asere.kotlin.js.dsl.value.get
import net.asere.kotlin.js.dsl.value.value

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val collection = Const { JsCollection.ref<JsNumber>() } `=` JsCollection.value(0.js, 1.js, 2.js, 3.js)
            For ({ Let { JsNumber.ref() } `=` 0 }, { it lt collection.getLength() }, { it.postInc() }) {
                Log(it)
            }

            val obj = Const { JsObject.ref("obj") } `=` JsSyntax("{ a: 5 }")
            For ({ +Const { JsObject.ref("key") } }, obj) {
                Log(obj[it])
            }


            For ({ +Const { JsNumber.ref() } }, collection) {
                Log(it)
            }
        }
    }
    println(result)
}