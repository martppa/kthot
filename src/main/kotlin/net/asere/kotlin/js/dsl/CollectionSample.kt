package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.dom.type.Window
import net.asere.kotlin.js.dsl.dom.type.screen.JsScreen
import net.asere.kotlin.js.dsl.ksp.KotlinJsl
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.type.array.JsArray
import net.asere.kotlin.js.dsl.type.array.def
import net.asere.kotlin.js.dsl.type.array.value
import net.asere.kotlin.js.dsl.type.lambda.l1.jsLambda
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.def
import net.asere.kotlin.js.dsl.type.number.js

fun main() {
    KotlinJsl.initialize()
    val syntax = js {
        val array = Const { JsArray.def<JsScreen>("array") } assign JsArray.value(Window.screen)
        Log("Screen height: ${array[0].height}")

        val numbers = Const { JsArray.def<JsNumber>("numbers") } assign JsArray.value(0.js, 1.js, 2.js)
        +numbers.forEach(jsLambda(param = JsNumber.def("number")) {
            Log(it)
        })
    }
    println(syntax)
}