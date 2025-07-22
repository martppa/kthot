package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.jsif.*
import net.asere.kotlin.js.dsl.syntax.operation.and
import net.asere.kotlin.js.dsl.syntax.operation.not
import net.asere.kotlin.js.dsl.syntax.operation.or
import net.asere.kotlin.js.dsl.type.JsBoolean

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val bool0 = Const { JsBoolean.ref() } `=` true
            val bool1 = Const { JsBoolean.ref() } `=` false
            val bool2 = Const { JsBoolean.ref() } `=` true

            +jsIf((!bool0 and bool1) or (bool1 and bool2)) {
                Log("and!")
            }.jsElseIf(bool0 or (bool1 or bool2)) {
                Log("or!")
            }.jsElseIf((bool0 or bool1) or bool2) {
                Log("or!")
            }.jsElse {
                Log("else!")
            }

            If ((!bool0 and bool1) or (bool1 and bool2)) {
                Log("and!")
            }
            ElseIf (bool0 or (bool1 or bool2)) {
                Log("or!")
            }
            ElseIf((bool0 or bool1) or bool2) {
                Log("or!")
            }
            Else {
                Log("else!")
            }
        }
    }
    println(result)
}