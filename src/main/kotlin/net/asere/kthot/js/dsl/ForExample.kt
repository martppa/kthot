package net.asere.kthot.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.declaration.Let
import net.asere.kthot.js.dsl.html.jslScript
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.syntax.jsif.If
import net.asere.kthot.js.dsl.syntax.loop.jsfor.For
import net.asere.kthot.js.dsl.syntax.loop.Break
import net.asere.kthot.js.dsl.syntax.loop.Continue
import net.asere.kthot.js.dsl.syntax.operational.equality.comparison.eq
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.comparison.lt
import net.asere.kthot.js.dsl.syntax.operational.arithmetical.operation.postInc
import net.asere.kthot.js.dsl.type.array.def
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.array.value
import net.asere.kthot.js.dsl.type.lambda.jsLambda
import net.asere.kthot.js.dsl.type.number.def
import net.asere.kthot.js.dsl.type.number.js
import net.asere.kthot.js.dsl.type.obj.def
import net.asere.kthot.js.dsl.type.obj.get
import net.asere.kthot.js.dsl.type.obj.value

fun main(vararg args: String) {
    val result = createHTML().body {
        jslScript {
            val collection = Const { JsArray.def<JsNumber>() } assign JsArray.value(0.js, 1.js, 2.js, 3.js)
            For ({ Let { JsNumber.def("i") } assign 0.js }, { it lt collection.getLength() }, { it.postInc() }) {
                Log(it)
                If (it lt 2) {
                    Break
                }
            }

            val obj = Const { JsObject.def("obj") } assign JsObject.value("{ a: 5 }")
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