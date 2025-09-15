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
import net.asere.kotlin.js.dsl.syntax.async.Await
import net.asere.kotlin.js.dsl.syntax.async.await
import net.asere.kotlin.js.dsl.syntax.group
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.syntax.jsreturn.Return
import net.asere.kotlin.js.dsl.type.lambda.jsLambda
import net.asere.kotlin.js.dsl.type.lambda.l0.Async
import net.asere.kotlin.js.dsl.type.lambda.l0.JsResultLambda0
import net.asere.kotlin.js.dsl.type.lambda.l0.asyncDef
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.def
import net.asere.kotlin.js.dsl.type.number.ref
import net.asere.kotlin.js.dsl.type.number.value
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.ref

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
        val lambda = Const { JsResultLambda0.asyncDef<JsNumber>("lambda") } assign Async {
            jsLambda {
                Log("Hi")
                Return { JsNumber.value(5) }
            }
        }
        +lambda().then(jsLambda(JsNumber.def("value")) {
            Log(it)
        })
        +group { await { lambda() } }.toExponential()
        val result = Const { JsNumber.def("result") } assign await { lambda() }
        Log(result)
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