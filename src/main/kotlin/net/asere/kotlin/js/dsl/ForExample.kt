package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.callable.JsLambda0
import net.asere.kotlin.js.dsl.callable.value
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.declaration.Let
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.jsif.If
import net.asere.kotlin.js.dsl.syntax.loop.jsfor.For
import net.asere.kotlin.js.dsl.syntax.loop.jswhile.Break
import net.asere.kotlin.js.dsl.syntax.loop.jswhile.Continue
import net.asere.kotlin.js.dsl.syntax.operation.eq
import net.asere.kotlin.js.dsl.syntax.operation.lt
import net.asere.kotlin.js.dsl.syntax.operation.postInc
import net.asere.kotlin.js.dsl.type.JsCollection
import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.type.JsObject
import net.asere.kotlin.js.dsl.type.js
import net.asere.kotlin.js.dsl.value.get
import net.asere.kotlin.js.dsl.value.value

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val collection = Const { JsCollection.ref<JsNumber>() } `=` JsCollection.value(0.js, 1.js, 2.js, 3.js)
            For ({ Let { JsNumber.ref("i") } `=` 0 }, { it lt collection.getLength() }, { it.postInc() }) {
                Log(it)
                If (it lt 2) {
                    Break
                }
            }

            val obj = Const { JsObject.ref("obj") } `=` JsSyntax("{ a: 5 }")
            For ({ Const { JsObject.ref("key") } }, obj) {
                Log(obj[it])
            }


            For ({ Const { JsNumber.ref() } }, collection) {
                Log(it)
                If (it eq 5.js) {
                    Continue
                }
            }

            For (collection, JsLambda0.value(JsNumber.ref()) { number1 ->
                Log(number1)
            })
        }
    }
    println(result)
}