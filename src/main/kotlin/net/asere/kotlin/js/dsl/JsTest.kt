package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.ksp.KotlinJsl
import net.asere.kotlin.js.dsl.ksp.annotation.JsClass
import net.asere.kotlin.js.dsl.ksp.annotation.JsConstructor
import net.asere.kotlin.js.dsl.ksp.annotation.JsFunction
import net.asere.kotlin.js.dsl.ksp.annotation.JsProperty
import net.asere.kotlin.js.dsl.ksp.js.Super
import net.asere.kotlin.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.jsreturn.Return
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.type.function.f0.AsyncResult
import net.asere.kotlin.js.dsl.type.function.f0.ResultFunction0
import net.asere.kotlin.js.dsl.type.isNullable
import net.asere.kotlin.js.dsl.type.lambda.l1.jsLambda
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.js
import net.asere.kotlin.js.dsl.type.number.ref
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.def
import net.asere.kotlin.js.dsl.type.string.ref
import net.asere.kotlin.js.dsl.type.string.value

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
        val getAsyncText = ResultFunction0("getAsyncText") {
            val value: JsString = Const { JsString.def("value", isNullable = true) } assign JsString.value("Returned from Js!")
            Return { value }
        }
        +getAsyncText().charAt(0.js)
    }
    println(syntax)

    // Output:
    // async function getAsyncText() {
    //     return 'Returned by a JavaScript function!'
    // }

    // getAsyncText().then((value) => {
    //     console.log(value)
    // })
}