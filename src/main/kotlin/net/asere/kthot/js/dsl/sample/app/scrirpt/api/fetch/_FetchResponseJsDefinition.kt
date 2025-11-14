package net.asere.kthot.js.dsl.sample.app.scrirpt.api.fetch

import net.asere.kthot.js.dsl.ksp.annotation.JsApiClass
import net.asere.kthot.js.dsl.ksp.annotation.JsFunction
import net.asere.kthot.js.dsl.ksp.annotation.JsProperty
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.value.JsValue

@JsApiClass(name = "JsResponse")
internal interface _FetchResponseJsDefinition<T : JsValue> {
    @JsFunction
    fun json(): JsPromise<T>

    @JsProperty
    val status: JsNumber
}