package net.asere.kthot.js.dsl.sample.snippets

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.html.jslScript
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.syntax.jsreturn.Return
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.array.def
import net.asere.kthot.js.dsl.type.array.value
import net.asere.kthot.js.dsl.type.function.Function
import net.asere.kthot.js.dsl.type.lambda.jsLambda
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kthot.js.dsl.type.lambda.l1.def
import net.asere.kthot.js.dsl.type.lambda.l2.JsLambda2
import net.asere.kthot.js.dsl.type.lambda.l2.def
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.def
import net.asere.kthot.js.dsl.type.number.js
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.def
import net.asere.kthot.js.dsl.type.string.js

fun main(vararg args: String) {
    val result = createHTML().body {
        jslScript {
            val sum = Const { JsLambda2.def<JsNumber, JsNumber>() } assign jsLambda(
                JsNumber.def("first"),
                JsNumber.def("second")
            ) { first, second ->
                Return { first + second }
            }
            Log(sum(5.js, 4.js))

            val setOnClick = Function("setOnClick", JsLambda1.def<JsString>("sender")) { callback ->
                +callback("button".js)
            }
            +setOnClick(jsLambda(JsString.def("sender")) {
                Log("Event emitted by".js + it)
            })

            val printItem = Const { JsLambda1.def<JsNumber>("printItem") } assign jsLambda(
                JsNumber.def("item"),
            ) { item ->
                Log(item)
            }
            val numberCollection =
                Const { JsArray.def<JsNumber>(name = "numberCollection", typeBuilder = JsNumber::syntax) } assign JsArray.value(100.js, 200.js, 300.js)
            +numberCollection.forEach(printItem)
        }
    }
    println(result)
}