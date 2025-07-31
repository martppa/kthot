package net.asere.kotlin.js.dsl.dom.type.media.stream

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsMediaStreamRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsMediaStream>(
    name ?: "media_stream_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsMediaStream, JsReference<JsMediaStream> {
    override fun toString(): String = present()
}

fun JsMediaStream.Companion.ref(name: String? = null, isNullable: Boolean = false): JsMediaStreamRef =
    JsMediaStreamRef(name, isNullable)

fun JsMediaStream.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsMediaStreamRef, JsMediaStream>() {
        override val reference: JsMediaStreamRef = JsMediaStreamRef(name, isNullable)
    }