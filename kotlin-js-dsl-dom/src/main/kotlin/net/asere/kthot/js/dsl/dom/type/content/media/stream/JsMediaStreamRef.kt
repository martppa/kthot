package net.asere.kthot.js.dsl.dom.type.content.media.stream

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsMediaStreamRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsMediaStream>(
    name ?: "media_stream_${ReferenceId.nextRefInt()}",
), JsMediaStream, JsReference<JsMediaStream> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsMediaStream.Companion.ref(name: String? = null): JsMediaStreamRef =
    JsMediaStreamRef(name)

@OptIn(JsInternalApi::class)
fun JsMediaStream.Companion.ref(element: JsElement): JsMediaStreamRef =
    JsMediaStreamRef(element.present())

@OptIn(JsInternalApi::class)
fun JsMediaStream.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsMediaStreamRef, JsMediaStream>() {
        override val reference: JsMediaStreamRef = JsMediaStreamRef(name)
    }