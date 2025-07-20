package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Constant
import net.asere.kotlin.js.dsl.log.jsLog
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.comparison.and
import net.asere.kotlin.js.dsl.syntax.comparison.eq
import net.asere.kotlin.js.dsl.syntax.comparison.or
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.type.JsBoolean
import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.type.js
import net.asere.kotlin.js.dsl.value.minus
import net.asere.kotlin.js.dsl.value.plus

fun main(vararg args: String) {
    var syntax = js {
        val bool0 = +JsBoolean.ref().declare(Constant).assign(true)
        val bool1 = +JsBoolean.ref().declare(Constant).assign(false)
        val result = +JsBoolean.ref("result").declare(Constant).assign(bool0 and bool1)
        +jsLog(result)
    }
    println(syntax)

    syntax = js {
        val bool0 = +JsBoolean.ref().declare(Constant).assign(5.js eq 5.js)
        val bool1 = +JsBoolean.ref().declare(Constant).assign(false)
        val bool2 = +JsBoolean.ref().declare(Constant).assign(true)
        +jsLog(bool1 and (bool2 or bool0))
    }
    println(syntax)
}