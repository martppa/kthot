package net.asere.kotlin.js.dsl.dom.syntax.media

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.media.JsMediaStreamTrack
import net.asere.kotlin.js.dsl.syntax.value.JsReferenceSyntax

class JsMediaStreamTrackSyntax(value: String) : JsReferenceSyntax<JsMediaStreamTrack>(value), JsMediaStreamTrack {
    constructor(value: JsElement) : this("$value")
}