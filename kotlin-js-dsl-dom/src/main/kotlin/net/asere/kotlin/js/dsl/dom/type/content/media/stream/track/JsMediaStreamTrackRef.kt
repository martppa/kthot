package net.asere.kotlin.js.dsl.dom.type.content.media.stream.track

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.dom.type.content.media.stream.JsMediaStream
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsMediaStreamTrackRef @InternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsMediaStreamTrack>(
    name ?: "media_stream_track_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsMediaStreamTrack, JsReference<JsMediaStreamTrack> {
    override fun toString(): String = present()
}

@OptIn(InternalApi::class)
fun JsMediaStream.Companion.ref(name: String? = null, isNullable: Boolean = false): JsMediaStreamTrackRef =
    JsMediaStreamTrackRef(name, isNullable)

@OptIn(InternalApi::class)
fun JsMediaStream.Companion.ref(element: JsElement, isNullable: Boolean = false): JsMediaStreamTrackRef =
    JsMediaStreamTrackRef(element.present(), isNullable)

@OptIn(InternalApi::class)
fun JsMediaStreamTrack.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsMediaStreamTrackRef, JsMediaStreamTrack>() {
        override val reference: JsMediaStreamTrackRef = JsMediaStreamTrackRef(name, isNullable)
    }