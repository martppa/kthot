package net.asere.kotlin.js.dsl.dom.type.media.stream.track

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsMediaStreamTrackSyntax(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsMediaStreamTrack>(value, isNullable), JsMediaStreamTrack {
    constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsMediaStreamTrack.Companion.syntax(value: String, isNullable: Boolean = false): JsMediaStreamTrack =
    JsMediaStreamTrackSyntax(value, isNullable)

fun JsMediaStreamTrack.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsMediaStreamTrack =
    JsMediaStreamTrackSyntax(value, isNullable)