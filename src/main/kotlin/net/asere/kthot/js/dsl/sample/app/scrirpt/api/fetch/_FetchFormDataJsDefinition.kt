package net.asere.kthot.js.dsl.sample.app.scrirpt.api.fetch

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.ksp.annotation.JsApiClass
import net.asere.kthot.js.dsl.ksp.annotation.JsFunction
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.string.JsString

@JsApiClass(name = "JsFormData")
internal interface _FetchFormDataJsDefinition {
    @JsFunction
    fun append(key: JsString, value: JsObject): JsNothing
}