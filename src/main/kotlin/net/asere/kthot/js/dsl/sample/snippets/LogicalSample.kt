package net.asere.kthot.js.dsl.sample.snippets

import net.asere.kthot.js.dsl.declaration.DeclarationType
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.syntax.operational.equality.comparison.eq
import net.asere.kthot.js.dsl.syntax.operational.logical.comparison.and
import net.asere.kthot.js.dsl.syntax.operational.logical.comparison.or
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.def
import net.asere.kthot.js.dsl.type.bool.unaryPlus
import net.asere.kthot.js.dsl.type.number.js

fun main(vararg args: String) {
    var syntax = js {
        val bool0 = +JsBoolean.def().declare(DeclarationType.CONST).assignValue(+true)
        val bool1 = +JsBoolean.def().declare(DeclarationType.CONST).assignValue(+false)
        val result = +JsBoolean.def("result").declare(DeclarationType.CONST).assignValue(bool0 and bool1)
        Log(result)
    }
    println(syntax)

    syntax = js {
        val bool0 = +JsBoolean.def().declare(DeclarationType.CONST).assignValue(5.js eq 5.js)
        val bool1 = +JsBoolean.def().declare(DeclarationType.CONST).assignValue(+false)
        val bool2 = +JsBoolean.def().declare(DeclarationType.CONST).assignValue(+true)
        Log(bool1 and (bool2 or bool0))
    }
    println(syntax)
}