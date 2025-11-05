package net.asere.kthot.js.dsl.sample.snippets

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.html.jslScript
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.syntax.jsif.*
import net.asere.kthot.js.dsl.syntax.operational.logical.comparison.and
import net.asere.kthot.js.dsl.syntax.operational.not
import net.asere.kthot.js.dsl.syntax.operational.logical.comparison.or
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.def
import net.asere.kthot.js.dsl.type.bool.unaryPlus

fun main(vararg args: String) {
    val result = createHTML().body {
        jslScript {
            val bool0 = Const { JsBoolean.def() } assign +true
            val bool1 = Const { JsBoolean.def() } assign +false
            val bool2 = Const { JsBoolean.def() } assign +true

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