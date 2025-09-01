package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.syntax.jswitch.Case
import net.asere.kotlin.js.dsl.syntax.jswitch.Switch
import net.asere.kotlin.js.dsl.syntax.loop.Break
import net.asere.kotlin.js.dsl.type.array.def
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.bool.js
import net.asere.kotlin.js.dsl.type.number.def
import net.asere.kotlin.js.dsl.type.number.js

fun main(vararg args: String) {
    val syntax = js {
        val number = Const { JsNumber.def("number") } assign 4
        Switch(number) {
            Case(2.js) {
                Log("Es un" + 2)
                Break
            }
            Case(4.js, 8.js) {
                Log("Es un " + 4 + " o un " + 8)
                Break
            }
        }
    }
    println(syntax)
}