package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.ksp.KotlinJsl
import net.asere.kotlin.js.dsl.ksp.annotation.JsClass
import net.asere.kotlin.js.dsl.ksp.annotation.JsConstructor
import net.asere.kotlin.js.dsl.ksp.annotation.JsFunction
import net.asere.kotlin.js.dsl.ksp.annotation.JsProperty
import net.asere.kotlin.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.async.await
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.type.array.JsArray
import net.asere.kotlin.js.dsl.type.lambda.jsLambda
import net.asere.kotlin.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kotlin.js.dsl.type.lambda.l1.def
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.JsNumberRef
import net.asere.kotlin.js.dsl.type.number.def
import net.asere.kotlin.js.dsl.type.number.ref
import net.asere.kotlin.js.dsl.type.promise.JsPromise
import net.asere.kotlin.js.dsl.type.promise.def
import net.asere.kotlin.js.dsl.type.promise.new
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.JsStringRef
import net.asere.kotlin.js.dsl.type.string.ref
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsClass
data class Test<T : JsArray<JsPromise<JsNumber>>> @JsConstructor constructor(
    @JsProperty
    val property: JsStringRef = JsString.ref("property"),
    @JsProperty
    val valuex: T
) : JavaScriptClass() {

    @JsProperty
    val number: JsNumberRef = JsNumber.ref("number")

    init {
        Constructor {
            This.property assign property
        }
    }

    @JsFunction
    fun function1(value: JsString) = js {
       This.property assign value
    }
}

fun main() {
    KotlinJsl.initialize()
    val syntax = js {
        val number = Const { JsNumber.def("5") } assign JsNumber.ref("a")
        val promise = Const { JsPromise.def<JsNumber>() } assign JsPromise.new {
            jsLambda(
                param1 = JsLambda1.def("onResolve"),
                param2 = JsLambda1.def("onError")
            ) { onResolve, onError ->
                +onResolve(number)
            }
        }
        val result = Const { JsNumber.def("result") } assign await { promise }
        Log(result)
    }
    println(syntax)
}