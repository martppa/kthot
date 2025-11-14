package net.asere.kthot.js.dsl.sample.app.scrirpt.model

import net.asere.kthot.js.dsl.ksp.annotation.JsClass
import net.asere.kthot.js.dsl.ksp.annotation.JsConstructor
import net.asere.kthot.js.dsl.ksp.annotation.JsProperty
import net.asere.kthot.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.value.JsValue

@JsClass(name = "JsPage")
internal data class _PageJsDefinition<T : JsValue> @JsConstructor constructor(
    @JsProperty
    val currentPage: JsNumber,
    @JsProperty
    val items: JsArray<T>
) : JavaScriptClass()