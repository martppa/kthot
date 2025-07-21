package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.jsLog
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.loop.jsfor.forI
import net.asere.kotlin.js.dsl.syntax.loop.jsfor.jsFor
import net.asere.kotlin.js.dsl.syntax.operation.*
import net.asere.kotlin.js.dsl.type.*
import net.asere.kotlin.js.dsl.value.get
import net.asere.kotlin.js.dsl.value.value

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val collection = +JsCollection.ref<JsNumber>().declare(Const).assign(JsCollection.value(0.js, 1.js, 2.js))
            +jsFor(forI, 0.js, forI lt collection.getLength(), forI.postInc()) {
                +jsLog(forI)
            }

            val obj = +JsObject.ref("obj").declare(Const).assign(JsSyntax("{ a: 5 }"))
            val key = JsObject.ref("key")
            +jsFor(key, obj) {
                +jsLog(obj[key])
            }


            val number = JsNumber.ref("number")
            +jsFor(number, collection) {
                +jsLog(collection[number])
            }
        }
    }
    println(result)
}