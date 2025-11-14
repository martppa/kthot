package net.asere.kthot.js.dsl.sample.app.scrirpt.model

import net.asere.kthot.js.dsl.ksp.annotation.JsClass
import net.asere.kthot.js.dsl.ksp.annotation.JsProperty
import net.asere.kthot.js.dsl.ksp.processor.js.JavaScriptClass
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.string.JsString

@JsClass(name = "JsRepo")
internal class _RepoJsDefinition : JavaScriptClass() {
    @JsProperty
    lateinit var id: JsNumber
    @JsProperty
    lateinit var  name: JsString
    @JsProperty
    lateinit var  description: JsString
    @JsProperty
    lateinit var  owner: JsString
    @JsProperty
    lateinit var  ownerAvatar: JsString
    @JsProperty
    lateinit var  fork: JsBoolean
}
