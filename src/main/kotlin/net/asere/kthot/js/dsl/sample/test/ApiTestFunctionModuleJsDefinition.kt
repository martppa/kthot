package net.asere.kthot.js.dsl.sample.test

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.ksp.annotation.JsApiFunctionModule
import net.asere.kthot.js.dsl.ksp.annotation.JsFunction
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.value.JsValue

@JsApiFunctionModule(name = "JsApiTestFunctionModule")
interface ApiTestFunctionModuleJsDefinition {

    @JsFunction
    fun returningFunction(): JsNothing

    @JsFunction
    fun stringReturningFunction(): JsString

    @JsFunction
    fun functionWithParameter(number: JsNumber): JsNothing

    @JsFunction
    fun functionWith2Parameter(number: JsNumber, string: JsString): JsNothing

    @JsFunction
    fun <T : JsValue> functionWithGenericParameter(parameter: T): JsNothing

    @JsFunction
    fun <T : JsValue> basicFunctionReturnGeneric(): T

    @JsFunction
    fun functionReturningGenericTypeParameter(): JsArray<JsString>

    @JsFunction
    fun functionWithGenericTypeParameterStringAndReturn(genericTyped: JsPromise<JsString>): JsArray<JsString>

    @JsFunction
    fun functionWithGenericTypeParameterString(genericTyped: JsPromise<JsString>): JsNothing

    @JsFunction
    fun <T : JsValue> functionWithGenericTypeParameter(genericTyped: JsPromise<T>): JsNothing

    @JsFunction
    fun functionWithComplexGenericParameterString(genericTyped: JsPromise<JsArray<JsString>>): JsNothing

    @JsFunction
    fun <T : JsValue> functionWithComplexGenericTypeParameter(genericTyped: JsPromise<JsArray<T>>): JsNothing
}