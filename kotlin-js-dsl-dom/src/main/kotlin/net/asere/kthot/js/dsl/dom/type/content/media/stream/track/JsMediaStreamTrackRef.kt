package net.asere.kthot.js.dsl.dom.type.content.media.stream.track

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.dom.type.content.media.stream.JsMediaStream
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsMediaStreamTrackRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsMediaStreamTrack>(
    name ?: "media_stream_track_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsMediaStreamTrack, JsReference<JsMediaStreamTrack> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsMediaStream.Companion.ref(name: String? = null, isNullable: Boolean = false): JsMediaStreamTrackRef =
    JsMediaStreamTrackRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsMediaStream.Companion.ref(element: JsElement, isNullable: Boolean = false): JsMediaStreamTrackRef =
    JsMediaStreamTrackRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsMediaStreamTrack.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsMediaStreamTrackRef, JsMediaStreamTrack>() {
        override val reference: JsMediaStreamTrackRef = JsMediaStreamTrackRef(name, isNullable)
    }