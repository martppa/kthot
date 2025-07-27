package net.asere.kotlin.js.dsl.dom.type.media

import net.asere.kotlin.js.dsl.syntax.value.JsBooleanSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.types.type.JsBoolean
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.JsString

/**
 * Represents a JavaScript `MediaStream` object, which is a stream of media content.
 */
interface JsMediaStream : JsObject {
    val id: JsString get() = JsStringSyntax("${this}.id")
    val active: JsBoolean get() = JsBooleanSyntax("${this}.active")

    // Further support for media coming in later versions
}