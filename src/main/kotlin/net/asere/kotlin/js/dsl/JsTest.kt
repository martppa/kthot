package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.dom.type.data.event.dom.JsDomEvent
import net.asere.kotlin.js.dsl.dom.type.data.event.dom.def
import net.asere.kotlin.js.dsl.dom.type.structure.form.button.JsButton
import net.asere.kotlin.js.dsl.dom.type.structure.form.button.ref
import net.asere.kotlin.js.dsl.ksp.KotlinJsl
import net.asere.kotlin.js.dsl.ksp.annotation.JsClass
import net.asere.kotlin.js.dsl.ksp.annotation.JsConstructor
import net.asere.kotlin.js.dsl.ksp.annotation.JsFunction
import net.asere.kotlin.js.dsl.ksp.annotation.JsProperty
import net.asere.kotlin.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kotlin.js.dsl.log.Log
import net.asere.kotlin.js.dsl.syntax.js
import net.asere.kotlin.js.dsl.type.lambda.jsLambda
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.JsNumberRef
import net.asere.kotlin.js.dsl.type.number.ref
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.JsStringRef
import net.asere.kotlin.js.dsl.type.string.ref
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsClass
data class Test<T : JsValue> @JsConstructor constructor(
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
        val button = JsButton.ref("btn")
        +button.setOnClick(jsLambda(param1 = JsDomEvent.def("event1")) {
            Log(it)
        })
    }
    println(syntax)

    // Output:
    // async function printMessage(message) {
    //     console.log(message)
    //     throw Error('Thrown error')
    //     return 'Value returned!'
    // }
    // try {
    //     const result = await printMessage('Printed from inside an async function!')
    //     console.log(result)
    // } catch(error) {
    //     console.log('An error occurred error')
    // }
}