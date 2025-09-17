package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.This
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.ksp.KotlinJsl
import net.asere.kotlin.js.dsl.ksp.annotation.JsClass
import net.asere.kotlin.js.dsl.ksp.annotation.JsConstructor
import net.asere.kotlin.js.dsl.ksp.annotation.JsFunction
import net.asere.kotlin.js.dsl.ksp.annotation.JsProperty
import net.asere.kotlin.js.dsl.ksp.js.Super
import net.asere.kotlin.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.syntax.jsreturn.Return
import net.asere.kotlin.js.dsl.type.lambda.jsAsyncResultLambda
import net.asere.kotlin.js.dsl.type.lambda.jsLambda
import net.asere.kotlin.js.dsl.type.lambda.l0.JsResultLambda0
import net.asere.kotlin.js.dsl.type.lambda.l0.asyncDef
import net.asere.kotlin.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kotlin.js.dsl.type.lambda.l1.def
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.ref
import net.asere.kotlin.js.dsl.type.number.value
import net.asere.kotlin.js.dsl.type.promise.JsPromise
import net.asere.kotlin.js.dsl.type.promise.new
import net.asere.kotlin.js.dsl.type.promise.ref
import net.asere.kotlin.js.dsl.type.promise.syntax
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.ref
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsClass
data class Test<T : JsValue> @JsConstructor constructor(
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
        val promise = JsPromise.ref<T> {  }
        +promise.then {
            Log(it)
        }
    }
}

fun main() {
    KotlinJsl.initialize()
    val syntax = js {
        val lambda = Const { JsResultLambda0.asyncDef<JsNumber>() } assign jsAsyncResultLambda {
            Log("Lambda returning value!")
            Return { JsNumber.value(5) }
        }
        +lambda().then()

        val promise: JsPromise<JsNothing> = JsPromise.syntax("J")

    }
    println(syntax)

    // Output:
    // const lambda_3 = async () => {
    //    console.log('Printed from within an async lambda!')
    // }
    // lambda_3().then()
}