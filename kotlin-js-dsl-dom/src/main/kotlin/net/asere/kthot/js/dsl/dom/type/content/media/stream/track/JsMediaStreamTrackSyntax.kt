package net.asere.kthot.js.dsl.dom.type.content.media.stream.track

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsMediaStreamTrackSyntax(value: String) :
    JsReferenceSyntax<JsMediaStreamTrack>(value), JsMediaStreamTrack {
    constructor(value: JsElement) : this("$value")
}

fun JsMediaStreamTrack.Companion.syntax(value: String): JsMediaStreamTrack =
    JsMediaStreamTrackSyntax(value)

fun JsMediaStreamTrack.Companion.syntax(value: JsElement): JsMediaStreamTrack =
    JsMediaStreamTrackSyntax(value)