package net.asere.kthot.js.dsl.sample.snippets

import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.dom.type.window.Window
import net.asere.kthot.js.dsl.dom.type.window.screen.JsScreen
import net.asere.kthot.js.dsl.ksp.Kthot
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.array.def
import net.asere.kthot.js.dsl.type.array.value
import net.asere.kthot.js.dsl.type.lambda.jsLambda
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.def
import net.asere.kthot.js.dsl.type.number.js

fun main() {
    Kthot.initialize()
    val syntax = js {
        val array = Const { JsArray.def<JsScreen>("array") } assign JsArray.value(Window.screen)
        Log("Screen height: ${array[0].height}")

        val numbers = Const { JsArray.def<JsNumber>("numbers") } assign JsArray.value(0.js, 1.js, 2.js)
        +numbers.forEach(jsLambda(param1 = JsNumber.def("number")) {
            Log(it)
        })
    }
    println(syntax)
}