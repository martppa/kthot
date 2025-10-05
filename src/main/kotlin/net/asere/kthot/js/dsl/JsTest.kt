package net.asere.kthot.js.dsl

import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.ksp.KotlinJsl
import net.asere.kthot.js.dsl.ksp.annotation.JsClass
import net.asere.kthot.js.dsl.ksp.annotation.JsConstructor
import net.asere.kthot.js.dsl.ksp.annotation.JsFunction
import net.asere.kthot.js.dsl.ksp.annotation.JsProperty
import net.asere.kthot.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.provider.register
import net.asere.kthot.js.dsl.syntax.async.await
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.array.syntax
import net.asere.kthot.js.dsl.type.error.JsError
import net.asere.kthot.js.dsl.type.lambda.jsLambda
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kthot.js.dsl.type.lambda.l1.def
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.JsNumberRef
import net.asere.kthot.js.dsl.type.number.def
import net.asere.kthot.js.dsl.type.number.ref
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.def
import net.asere.kthot.js.dsl.type.promise.new
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.JsStringRef
import net.asere.kthot.js.dsl.type.string.ref

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
    register { element, isNullable -> JsArray.syntax<JsPromise<JsNumber>>(value = element, isNullable = isNullable, typeBuilder = ::provide) }
    KotlinJsl.initialize()
    val syntax = js {
        val number = Const { JsNumber.def("5") } assign JsNumber.ref("a")
        val promise = Const { JsPromise.def<JsNumber>() } assign JsPromise.new(
            jsLambda(
                param1 = JsLambda1.def("onResolve"),
                param2 = JsLambda1.def("onError")
            ) { onResolve, onError ->
                +onResolve(number)
            }
        )
        val result = Const { JsNumber.def("result") } assign await { promise }
        Log(result)
    }
    println(syntax)
}