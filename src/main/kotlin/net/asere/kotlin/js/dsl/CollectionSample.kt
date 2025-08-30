package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.dom.type.Window
import net.asere.kotlin.js.dsl.dom.type.screen.JsScreen
import net.asere.kotlin.js.dsl.ksp.KotlinJs
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.type.array.JsArray
import net.asere.kotlin.js.dsl.type.array.def
import net.asere.kotlin.js.dsl.type.array.value

fun main() {
    KotlinJs.initialize()
    val syntax = js {
        val array = Const { JsArray.def<JsScreen>("array") } `=` JsArray.value(Window.screen)
        Log("Screen height: ${array[0].height}")
    }
    println(syntax)
}