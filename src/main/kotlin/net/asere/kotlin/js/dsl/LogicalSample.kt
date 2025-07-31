package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.syntax.operation.and
import net.asere.kotlin.js.dsl.syntax.operation.eq
import net.asere.kotlin.js.dsl.syntax.operation.or
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.def
import net.asere.kotlin.js.dsl.type.number.js

fun main(vararg args: String) {
    var syntax = js {
        val bool0 = +JsBoolean.def().declare(Const).assign(true)
        val bool1 = +JsBoolean.def().declare(Const).assign(false)
        val result = +JsBoolean.def("result").declare(Const).assign(bool0 and bool1)
        Log(result)
    }
    println(syntax)

    syntax = js {
        val bool0 = +JsBoolean.def().declare(Const).assign(5.js eq 5.js)
        val bool1 = +JsBoolean.def().declare(Const).assign(false)
        val bool2 = +JsBoolean.def().declare(Const).assign(true)
        Log(bool1 and (bool2 or bool0))
    }
    println(syntax)
}