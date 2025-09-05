package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.declaration.Let
import net.asere.kotlin.js.dsl.ksp.KotlinJsl
import net.asere.kotlin.js.dsl.ksp.annotation.JsClass
import net.asere.kotlin.js.dsl.ksp.annotation.JsConstructor
import net.asere.kotlin.js.dsl.ksp.annotation.JsFunction
import net.asere.kotlin.js.dsl.ksp.annotation.JsProperty
import net.asere.kotlin.js.dsl.ksp.js.Super
import net.asere.kotlin.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.Return
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.syntax.jsif.If
import net.asere.kotlin.js.dsl.syntax.loop.Break
import net.asere.kotlin.js.dsl.syntax.loop.Continue
import net.asere.kotlin.js.dsl.syntax.loop.jsfor.For
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.gt
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.comparison.lt
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation.plus
import net.asere.kotlin.js.dsl.syntax.operational.arithmetical.operation.postInc
import net.asere.kotlin.js.dsl.syntax.operational.equality.comparison.eq
import net.asere.kotlin.js.dsl.syntax.operational.logical.comparison.and
import net.asere.kotlin.js.dsl.syntax.operational.logical.comparison.or
import net.asere.kotlin.js.dsl.type.array.JsArray
import net.asere.kotlin.js.dsl.type.array.def
import net.asere.kotlin.js.dsl.type.array.value
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.def
import net.asere.kotlin.js.dsl.type.function.f2.Function
import net.asere.kotlin.js.dsl.type.lambda.l2.JsLambda2
import net.asere.kotlin.js.dsl.type.lambda.l2.def
import net.asere.kotlin.js.dsl.type.lambda.l2.jsLambda
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.def
import net.asere.kotlin.js.dsl.type.number.js
import net.asere.kotlin.js.dsl.type.number.ref
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.obj.def
import net.asere.kotlin.js.dsl.type.obj.syntax
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.def
import net.asere.kotlin.js.dsl.type.string.ref
import net.asere.kotlin.js.dsl.type.value.get

@JsClass
data class Test @JsConstructor constructor(
    @JsProperty
    val property: JsString = JsString.ref("property")
) : JavaScriptClass() {

    @JsProperty
    val number: JsNumber = JsNumber.ref("number")

    init {
        Constructor {
            Super(number)
            This.property assign property
        }
    }

    @JsFunction
    fun function1(value: JsNumber) = js {
        This.property assign value
    }
}

fun main() {
    KotlinJsl.initialize()
    val syntax = js {
        val obj = Const { JsObject.def("obj") } assign JsObject.syntax("{ a: 5 }")
        For ({ Const { JsObject.def("key") } }, obj) {
            Log(obj[it])
        }
    }
    println(syntax)
}