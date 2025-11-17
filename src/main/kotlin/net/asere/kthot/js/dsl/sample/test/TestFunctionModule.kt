package net.asere.kthot.js.dsl.sample.test

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.ksp.annotation.JsFunction
import net.asere.kthot.js.dsl.ksp.annotation.JsFunctionModule
import net.asere.kthot.js.dsl.ksp.processor.js.JavaScriptModule
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.genericSyntax
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.syntax.jsreturn.Return
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.array.syntax
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.js
import net.asere.kthot.js.dsl.type.string.syntax
import net.asere.kthot.js.dsl.type.string.value
import net.asere.kthot.js.dsl.type.value.JsValue

@JsFunctionModule(name = "JsTestFunctionModule")
class TestFunctionModule : JavaScriptModule() {
    @JsFunction
    fun returningFunction(): JsNothing = JsNothing.syntax(js {
        Log("Sample function")
    })

    @JsFunction
    fun stringReturningFunction(): JsString = JsString.syntax {
        Return { "Hi".js }
    }

    @JsFunction
    fun functionWithParameter(number: JsNumber): JsNothing = JsNothing.syntax {
        Log(JsString.value("Nothing returned for #0", number))
    }

    @JsFunction
    inline fun <reified T : JsValue> basicFunctionReturnGeneric(): T = genericSyntax {
        Return { provide(JsString.value("")) }
    }

    @JsFunction
    fun functionWith2Parameter(number: JsNumber, string: JsString): JsNothing = JsNothing.syntax {
        Log(JsString.value("Nothing returned for #0 and $1", number, string))
    }

    @JsFunction
    fun <T : JsValue> functionWithGenericParameter(parameter: T): JsNothing = JsNothing.syntax {
        Log(JsString.value("Nothing returned for #0", parameter))
    }

    @JsFunction
    fun functionReturningGenericTypeParameter(): JsArray<JsString> = JsArray.syntax {
        Return { JsArray.syntax("firstElement") }
    }

    @JsFunction
    fun functionWithGenericTypeParameterStringAndReturn(
        genericTyped: JsPromise<JsString>
    ): JsArray<JsString> = JsArray.syntax {
        Return { JsArray.syntax("firstElement") }
    }

    @JsFunction
    fun functionWithGenericTypeParameterString(genericTyped: JsPromise<JsString>): JsNothing = JsNothing.syntax {
        Log("Nothing!")
    }

    @JsFunction
    fun <T : JsValue> functionWithGenericTypeParameter(genericTyped: JsPromise<T>): JsNothing = JsNothing.syntax {
        Log("Nothing!")
    }

    @JsFunction
    fun functionWithComplexGenericParameterString(
        genericTyped: JsPromise<JsArray<JsString>>
    ): JsNothing = JsNothing.syntax {
        Log("Nothing!")
    }

    @JsFunction
    fun <T : JsValue> functionWithComplexGenericTypeParameter(
        genericTyped: JsPromise<JsArray<T>>
    ): JsNothing = JsNothing.syntax {
        Log("Nothing!")
    }
}