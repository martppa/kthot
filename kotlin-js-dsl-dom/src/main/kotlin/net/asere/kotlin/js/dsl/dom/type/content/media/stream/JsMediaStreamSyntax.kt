package net.asere.kotlin.js.dsl.dom.type.content.media.stream

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsReferenceSyntax

class JsMediaStreamSyntax internal constructor(value: String, isNullable: Boolean) :
    JsReferenceSyntax<JsMediaStream>(value, isNullable), JsMediaStream {
    internal constructor(value: JsElement, isNullable: Boolean) : this("$value", isNullable)
}

fun JsMediaStream.Companion.syntax(value: String, isNullable: Boolean = false): JsMediaStream =
    JsMediaStreamSyntax(value, isNullable)

fun JsMediaStream.Companion.syntax(value: JsElement, isNullable: Boolean = false): JsMediaStream =
    JsMediaStreamSyntax(value, isNullable)