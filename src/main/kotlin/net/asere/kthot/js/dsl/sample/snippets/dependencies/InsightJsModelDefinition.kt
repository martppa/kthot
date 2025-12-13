package net.asere.kthot.js.dsl.sample.snippets.dependencies

import net.asere.kthot.js.dsl.ksp.annotation.JsClass
import net.asere.kthot.js.dsl.ksp.annotation.JsConstructor
import net.asere.kthot.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kthot.js.dsl.type.string.JsString

@JsClass(name = "JsInsight")
internal data class InsightJsModelDefinition @JsConstructor constructor(
    val keyword: JsString,
    val symbol: JsString,
    val sentiment: JsString,
) : JavaScriptClass()