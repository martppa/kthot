package net.asere.kthot.js.dsl.sample.app.scrirpt.api.fetch

import net.asere.kthot.js.dsl.ksp.annotation.JsApiFunctionModule
import net.asere.kthot.js.dsl.ksp.annotation.JsFunction
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.value.JsValue

@JsApiFunctionModule(name = "JsFetch")
internal interface _FetchFunctionJsDefinition {
    @JsFunction
    fun <T : JsValue> fetch(url: JsString, data: JsFetchData): JsPromise<JsResponse<T>>
}