package net.asere.kthot.js.dsl.sample.test

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.ksp.annotation.JsClass
import net.asere.kthot.js.dsl.ksp.annotation.JsConstructor
import net.asere.kthot.js.dsl.ksp.annotation.JsFunction
import net.asere.kthot.js.dsl.ksp.annotation.JsProperty
import net.asere.kthot.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.syntax
import net.asere.kthot.js.dsl.syntax.JsGenerics
import net.asere.kthot.js.dsl.syntax.jsreturn.Return
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.array.syntax
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.JsStringRef
import net.asere.kthot.js.dsl.type.string.js
import net.asere.kthot.js.dsl.type.string.ref
import net.asere.kthot.js.dsl.type.string.syntax
import net.asere.kthot.js.dsl.type.string.value
import net.asere.kthot.js.dsl.type.value.JsValue


@JsClass(name = "JsClassTest2")
class ClassTest2FunctionModule : JavaScriptClass() {

}

@JsClass(name = "JsClassTest")
class ClassTestFunctionModule<T : JsValue> @JsConstructor constructor(
    @JsProperty
    val genericProperty: T
) : JavaScriptClass() {

    @JsProperty
    val stringProperty: JsStringRef = JsString.ref("stringProperty")

    init {
        importModule(JsClassTest2.Module)
        Constructor {
            This.genericProperty assign genericProperty
            This.stringProperty assign stringProperty
        }
    }

    @JsFunction
    fun returningFunction(): JsNothing = JsNothing.syntax {
        Log("Sample function")
    }

    @JsFunction
    fun stringReturningFunction(): JsString = JsString.syntax {
        Return { "Hi".js }
    }

    @JsFunction
    fun functionWithParameter(number: JsNumber): JsNothing = JsNothing.syntax {
        Log(JsString.value("Nothing returned for #0", number))
    }

    @JsFunction
    fun basicFunctionReturnGeneric(): T = JsGenerics.syntax {
        Return { genericProperty }
    }

    @JsFunction
    fun functionWith2Parameter(number: JsNumber, string: JsString): JsNothing = JsNothing.syntax {
        Log(JsString.value("Nothing returned for #0 and #1", number, string))
    }

    @JsFunction
    fun functionWithGenericParameter(parameter: T): JsNothing = JsNothing.syntax {
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
    fun functionWithGenericTypeParameter(genericTyped: JsPromise<T>): JsNothing = JsNothing.syntax {
        Log("Nothing!")
    }

    @JsFunction
    fun functionWithComplexGenericParameterString(
        genericTyped: JsPromise<JsArray<JsString>>
    ): JsNothing = JsNothing.syntax {
        Log("Nothing!")
    }

    @JsFunction
    fun functionWithComplexGenericTypeParameter(
        genericTyped: JsPromise<JsArray<T>>
    ): JsNothing = JsNothing.syntax {
        Log("Nothing!")
    }
}