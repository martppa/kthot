package net.asere.kotlin.js.dsl.dom.type.media.stream

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsMediaStreamSyntax internal constructor(value: String) : JsReferenceSyntax<JsMediaStream>(value), JsMediaStream {
    internal constructor(value: JsElement) : this("$value")
}

fun JsMediaStream.Companion.syntax(value: String): JsMediaStreamSyntax = JsMediaStreamSyntax(value)
fun JsMediaStream.Companion.syntax(value: JsElement): JsMediaStreamSyntax = JsMediaStreamSyntax(value)