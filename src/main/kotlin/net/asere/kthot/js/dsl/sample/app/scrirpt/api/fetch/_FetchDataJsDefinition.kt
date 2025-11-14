package net.asere.kthot.js.dsl.sample.app.scrirpt.api.fetch

import net.asere.kthot.js.dsl.ksp.annotation.JsClass
import net.asere.kthot.js.dsl.ksp.annotation.JsProperty
import net.asere.kthot.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kthot.js.dsl.type.obj.JsObjectRef
import net.asere.kthot.js.dsl.type.string.JsStringRef
import net.asere.kthot.js.dsl.type.string.js

val FETCH_METHOD_POST = "POST".js
val FETCH_METHOD_PUT = "PUT".js
val FETCH_METHOD_DELETE = "DELETE".js
val FETCH_METHOD_GET = "GET".js
val FETCH_METHOD_OPTION = "OPTION".js
val FETCH_METHOD_PATCH = "PATCH".js

@JsClass(name = "JsFetchData")
internal class _FetchDataJsDefinition : JavaScriptClass()  {
    @JsProperty
    lateinit var method: JsStringRef
    @JsProperty
    lateinit var body: JsObjectRef
    @JsProperty
    lateinit var headers: JsObjectRef
}