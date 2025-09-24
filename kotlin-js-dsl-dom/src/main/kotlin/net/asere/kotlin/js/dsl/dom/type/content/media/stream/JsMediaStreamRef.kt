package net.asere.kotlin.js.dsl.dom.type.content.media.stream

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsMediaStreamRef @InternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsMediaStream>(
    name ?: "media_stream_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsMediaStream, JsReference<JsMediaStream> {
    override fun toString(): String = present()
}

@OptIn(InternalApi::class)
fun JsMediaStream.Companion.ref(name: String? = null, isNullable: Boolean = false): JsMediaStreamRef =
    JsMediaStreamRef(name, isNullable)

@OptIn(InternalApi::class)
fun JsMediaStream.Companion.ref(element: JsElement, isNullable: Boolean = false): JsMediaStreamRef =
    JsMediaStreamRef(element.present(), isNullable)

@OptIn(InternalApi::class)
fun JsMediaStream.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsMediaStreamRef, JsMediaStream>() {
        override val reference: JsMediaStreamRef = JsMediaStreamRef(name, isNullable)
    }