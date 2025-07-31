package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.declaration.Let
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.jsif.If
import net.asere.kotlin.js.dsl.syntax.loop.jsfor.For
import net.asere.kotlin.js.dsl.syntax.loop.Break
import net.asere.kotlin.js.dsl.syntax.loop.Continue
import net.asere.kotlin.js.dsl.syntax.operation.eq
import net.asere.kotlin.js.dsl.syntax.operation.lt
import net.asere.kotlin.js.dsl.syntax.operation.postInc
import net.asere.kotlin.js.dsl.type.array.def
import net.asere.kotlin.js.dsl.type.array.JsArray
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.`object`.JsObject
import net.asere.kotlin.js.dsl.type.bool.js
import net.asere.kotlin.js.dsl.type.value.get
import net.asere.kotlin.js.dsl.type.value.lambda.jsLambda
import net.asere.kotlin.js.dsl.type.array.value

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val collection = Const { JsArray.def<JsNumber>() } `=` JsArray.value(0.js, 1.js, 2.js, 3.js)
            For ({ Let { JsNumber.def("i") } `=` 0 }, { it lt collection.getLength() }, { it.postInc() }) {
                Log(it)
                If (it lt 2) {
                    Break
                }
            }

            val obj = Const { JsObject.def("obj") } `=` JsSyntax("{ a: 5 }")
            For ({ Const { JsObject.def("key") } }, obj) {
                Log(obj[it])
            }


            For ({ Const { JsNumber.def() } }, collection) {
                Log(it)
                If (it eq 5.js) {
                    Continue
                }
            }

            For (collection, jsLambda(JsNumber.def()) { number1 ->
                Log(number1)
            })
        }
    }
    println(result)
}