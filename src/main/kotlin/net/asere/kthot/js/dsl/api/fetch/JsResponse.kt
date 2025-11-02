package net.asere.kthot.js.dsl.api.fetch

import net.asere.kthot.js.dsl.ksp.annotation.JsApiClass
import net.asere.kthot.js.dsl.ksp.annotation.JsApiFunctionFile
import net.asere.kthot.js.dsl.ksp.annotation.JsFunction
import net.asere.kthot.js.dsl.ksp.annotation.JsProperty
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.value.JsValue

@JsApiFunctionFile(name = "JsResponse")
internal interface _FetchResponseApiDefinition {
    @JsFunction
    fun <T : JsValue> json(): JsPromise<T>


}