package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.Return
import net.asere.kotlin.js.dsl.syntax.operation.plus
import net.asere.kotlin.js.dsl.type.array.JsArray
import net.asere.kotlin.js.dsl.type.array.def
import net.asere.kotlin.js.dsl.type.array.value
import net.asere.kotlin.js.dsl.type.function.f1.Function
import net.asere.kotlin.js.dsl.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.type.lambda.l2.JsLambda2
import net.asere.kotlin.js.dsl.type.lambda.l2.def
import net.asere.kotlin.js.dsl.type.lambda.l2.jsLambda
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.js
import net.asere.kotlin.js.dsl.type.number.syntax
import net.asere.kotlin.js.dsl.type.reference.lambda.def
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.def
import net.asere.kotlin.js.dsl.type.string.js
import net.asere.kotlin.js.dsl.type.value.lambda.jsLambda

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val sum = Const { JsLambda2.def<JsNumber, JsNumber>() } `=` jsLambda(
                JsString.def("first"),
                JsString.def("second")
            ) { first, second ->
                Return(first + second)
            }
            Log(sum(5.js, 4.js))

            val setOnClick = Function("setOnClick", JsLambda1.def<JsString>("sender")) { callback ->
                +callback("button".js)
            }
            +setOnClick(jsLambda(JsString.def("sender")) {
                Log("Event emitted by".js + it)
            })

            val printItem = Const { JsLambda1.def<JsNumber>("printItem") } `=` jsLambda(
                JsString.def("item"),
            ) { item ->
                Log(item)
            }
            val numberCollection =
                Const { JsArray.def<JsNumber>(name = "numberCollection", refBuilder = JsNumber::syntax) } `=` JsArray.value(100.js, 200.js, 300.js)
            +numberCollection.forEach(printItem)
        }
    }
    println(result)
}