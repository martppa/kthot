package net.asere.kthot.js.dsl.sample.snippets.dependencies

import net.asere.kthot.js.dsl.ksp.annotation.JsClass
import net.asere.kthot.js.dsl.ksp.annotation.JsConstructor
import net.asere.kthot.js.dsl.ksp.annotation.JsProperty
import net.asere.kthot.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.date.JsDate
import net.asere.kthot.js.dsl.type.string.JsString

@JsClass("JsNews")
internal data class NewsJsModelDefinition @JsConstructor constructor(
    @JsProperty val id: JsString,
    @JsProperty val title: JsString,
    @JsProperty val uriTitle: JsString,
    @JsProperty val summary: JsString,
    @JsProperty val author: JsString,
    @JsProperty val insights: JsArray<JsInsight>,
    @JsProperty val url: JsString,
    @JsProperty val imageUrl: JsString,
    @JsProperty val keywords: JsArray<JsString>,
    @JsProperty val publishedAt: JsDate,
    @JsProperty val publisher: JsString,
    @JsProperty val justness: JsJustness,
    @JsProperty val sentiment: JsSentiment,
) : JavaScriptClass()