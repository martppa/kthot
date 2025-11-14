package net.asere.kthot.js.dsl.sample.snippets

import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.ksp.Kthot
import net.asere.kthot.js.dsl.ksp.annotation.*
import net.asere.kthot.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kthot.js.dsl.ksp.processor.js.JavaScriptModule
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.provider.register
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.syntax.jsswitch.Case
import net.asere.kthot.js.dsl.syntax.jsswitch.Switch
import net.asere.kthot.js.dsl.syntax.loop.Break
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.array.syntax
import net.asere.kthot.js.dsl.type.number.*
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.JsStringRef

@JsFunctionModule(name = "prebadName")
internal class _ApiTestPrieba : JavaScriptModule() {
    @JsAsync
    @JsFunction
    fun prueba(): JsPromise<JsString> = JsPromise.syntax(js {

    })
}

@JsApiFunctionModule(name = "prebadNameFile")
internal interface _ApiTestPriebaFile {
    @JsFunction
    fun prueba(): JsPromise<JsString>
}

@JsApiClass
class ApiSample

@JsClass(name = "JsPruebaDefinitiva")
data class Test<T : JsArray<JsPromise<JsNumber>>> @JsConstructor constructor(
    @JsProperty
    val property2: JsStringRef,

    @JsProperty
    val valuex: T,

    @JsProperty
    val syntaxSample: JsString,

    @JsProperty
    val primise: JsPromise<JsArray<JsString>>
) : JavaScriptClass() {

    @JsProperty
    lateinit var primisePropertyy: JsPromise<JsString>

    @JsProperty
    val number: JsNumberRef = JsNumber.ref("number")

    init {
        Constructor {
            This.property2 assign property2
        }
    }

    @JsFunction
    fun function1(value: JsString) = js {
       This.property2 assign value
    }

    @JsFunction
    fun promiseTest(): JsPromise<JsString> = JsPromise.syntax<JsString>(js {

    })
}

fun main() {
    register { element -> JsArray.syntax<JsPromise<JsNumber>>(value = element, typeBuilder = ::provide) }
    Kthot.initialize()
    val syntax = js {
        val number = Const { JsNumber.def("number") } assign 4.js
        Switch(number) {
            Case(2.js) {
                Log("Es un" + 2)
                Break
            }
            Case(4.js, 8.js) {
                Log("Es un " + 4 + " o un " + 8)
                Break
            }
        }
    }
    println(syntax)
}