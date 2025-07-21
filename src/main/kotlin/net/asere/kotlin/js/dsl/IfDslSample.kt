package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.jsif.jsElse
import net.asere.kotlin.js.dsl.syntax.jsif.jsElseIf
import net.asere.kotlin.js.dsl.syntax.jsif.jsIf
import net.asere.kotlin.js.dsl.syntax.operation.and
import net.asere.kotlin.js.dsl.syntax.operation.not
import net.asere.kotlin.js.dsl.syntax.operation.or
import net.asere.kotlin.js.dsl.type.JsBoolean
import net.asere.kotlin.js.dsl.type.js

fun main(vararg args: String) {
    val result = createHTML().body {
        jsScript {
            val bool0 = +JsBoolean.ref().declare(Const).assign(true.js)
            val bool1 = +JsBoolean.ref().declare(Const).assign(false.js)
            val bool2 = +JsBoolean.ref().declare(Const).assign(false.js)

            +jsIf((!bool0 and bool1) or (bool1 and bool2)) {
                Log("and!")
            }.jsElseIf(bool0 or (bool1 or bool2)) {
                Log("or!")
            }.jsElseIf((bool0 or bool1) or bool2) {
                Log("or!")
            }.jsElse {
                Log("else!")
            }
        }
    }
    println(result)
}