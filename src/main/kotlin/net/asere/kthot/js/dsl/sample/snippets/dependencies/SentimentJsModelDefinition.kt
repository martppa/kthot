package net.asere.kthot.js.dsl.sample.snippets.dependencies

import net.asere.kthot.js.dsl.ksp.annotation.JsClass
import net.asere.kthot.js.dsl.ksp.annotation.JsConstructor
import net.asere.kthot.js.dsl.ksp.annotation.JsProperty
import net.asere.kthot.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.string.JsString

@JsClass(name = "JsSentiment")
internal data class SentimentJsModelDefinition @JsConstructor constructor(
    @JsProperty val value: JsString,
    @JsProperty val score: JsNumber,
) : JavaScriptClass()