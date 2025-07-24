package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.declaration.Let
import net.asere.kotlin.js.dsl.declaration.Var
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.types.reference.def
import net.asere.kotlin.js.dsl.types.type.JsBoolean
import net.asere.kotlin.js.dsl.types.type.JsCollection
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.js
import net.asere.kotlin.js.dsl.types.value.lambda.jsLambda
import net.asere.kotlin.js.dsl.types.value.value

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val constBoolean = Const { JsBoolean.def() }
            val letBoolean = Let { JsBoolean.def() } `=` true
            val varBoolean = Var { JsBoolean.def() } `=` false

            val collection = Const { JsCollection.def<JsNumber>() } `=` JsCollection.value(0.js, 1.js, 2.js, 3.js, 4.js)
            +collection.forEach(jsLambda(JsNumber.def()) { number1 ->
                Log(number1)
            })
        }
    }
    println(result)
}