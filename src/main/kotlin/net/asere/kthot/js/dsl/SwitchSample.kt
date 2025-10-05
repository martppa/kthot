package net.asere.kthot.js.dsl

import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.syntax.jsswitch.Case
import net.asere.kthot.js.dsl.syntax.jsswitch.Switch
import net.asere.kthot.js.dsl.syntax.loop.Break
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.def
import net.asere.kthot.js.dsl.type.number.js

fun main(vararg args: String) {
    val syntax = js {
        val number = Const { JsNumber.def("number") } assign 4.js
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