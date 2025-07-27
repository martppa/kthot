package net.asere.kotlin.js.dsl.dom.syntax.media

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.media.JsMediaStream
import net.asere.kotlin.js.dsl.syntax.value.JsReferenceSyntax

class JsMediaStreamSyntax(value: String) : JsReferenceSyntax<JsMediaStream>(value), JsMediaStream {
    constructor(value: JsElement) : this("$value")
}