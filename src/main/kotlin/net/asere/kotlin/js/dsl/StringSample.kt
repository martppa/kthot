package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.callable.JsFunction
import net.asere.kotlin.js.dsl.declaration.Constant
import net.asere.kotlin.js.dsl.declaration.Mutable
import net.asere.kotlin.js.dsl.log.jsLog
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.syntax.jsReturn
import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.type.JsObject
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.value.plus
import net.asere.kotlin.js.dsl.value.value

fun main(vararg args: String) {
    val run: JsScriptScope.() -> Unit = {
        val function = +JsFunction("sum", JsNumber.ref("num1"), JsNumber.ref("num2")) { num1, num2 ->
            val result = +JsObject.ref("result")
                .declare(Constant)
                .assign(num1 + num2)
            +jsReturn(result)
        }
        val sumResult = +JsNumber
            .ref("sumResult")
            .declare(Mutable)
            .assign(function(JsNumber.value(5), JsNumber.value(10)))
        +jsLog(sumResult)
    }
    val scope = JsSyntaxScope()
    run(scope)
    println(scope.present())
}