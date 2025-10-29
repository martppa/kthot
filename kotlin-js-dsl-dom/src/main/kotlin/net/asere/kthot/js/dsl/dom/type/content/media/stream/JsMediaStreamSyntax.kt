package net.asere.kthot.js.dsl.dom.type.content.media.stream

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsReferenceSyntax

class JsMediaStreamSyntax internal constructor(value: String) :
    JsReferenceSyntax<JsMediaStream>(value), JsMediaStream {
    internal constructor(value: JsElement) : this("$value")
}

fun JsMediaStream.Companion.syntax(value: String): JsMediaStream =
    JsMediaStreamSyntax(value)

fun JsMediaStream.Companion.syntax(value: JsElement): JsMediaStream =
    JsMediaStreamSyntax(value)