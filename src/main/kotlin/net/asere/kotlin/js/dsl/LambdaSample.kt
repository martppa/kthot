package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.callable.*
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.types.reference.lambda.ref
import net.asere.kotlin.js.dsl.syntax.Return
import net.asere.kotlin.js.dsl.syntax.operation.plus
import net.asere.kotlin.js.dsl.type.*
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda2
import net.asere.kotlin.js.dsl.types.type.JsCollection
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.JsString
import net.asere.kotlin.js.dsl.types.type.js
import net.asere.kotlin.js.dsl.types.value.lambda.jsLambda
import net.asere.kotlin.js.dsl.types.value.value

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val sum = Const { JsLambda2.ref<JsNumber, JsNumber>() } `=` jsLambda(
                JsString.ref("first"),
                JsString.ref("second")
            ) { first, second ->
                Return(first + second)
            }
            Log(sum(5.js, 4.js))

            val setOnClick = Function("setOnClick", JsLambda1.ref<JsString>("sender")) { callback ->
                +callback("button".js)
            }
            +setOnClick(jsLambda(JsString.ref("sender")) {
                Log("Event emitted by".js + it)
            })

            val printItem = Const { JsLambda1.ref<JsNumber>("printItem") } `=` jsLambda(
                JsString.ref("item"),
            ) { item ->
                Log(item)
            }
            val numberCollection = Const { JsCollection.ref<JsNumber>("numberCollection") } `=` JsCollection.value(100.js, 200.js, 300.js)
            +numberCollection.forEach(printItem)
        }
    }
    println(result)
}