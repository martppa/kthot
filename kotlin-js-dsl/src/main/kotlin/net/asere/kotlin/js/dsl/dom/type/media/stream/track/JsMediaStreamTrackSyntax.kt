package net.asere.kotlin.js.dsl.dom.type.media.stream.track

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.dom.type.media.stream.JsMediaStream
import net.asere.kotlin.js.dsl.dom.type.media.stream.JsMediaStreamSyntax
import net.asere.kotlin.js.dsl.dom.type.media.stream.track.JsMediaStreamTrack
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsMediaStreamTrackSyntax(value: String) : JsReferenceSyntax<JsMediaStreamTrack>(value), JsMediaStreamTrack {
    constructor(value: JsElement) : this("$value")
}

fun JsMediaStreamTrack.Companion.syntax(value: String): JsMediaStreamTrack = JsMediaStreamTrackSyntax(value)
fun JsMediaStreamTrack.Companion.syntax(value: JsElement): JsMediaStreamTrack = JsMediaStreamTrackSyntax(value)