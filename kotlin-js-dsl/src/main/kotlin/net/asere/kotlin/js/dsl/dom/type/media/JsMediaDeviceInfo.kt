package net.asere.kotlin.js.dsl.dom.type.media

import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.JsString

/**
 * Represents a JavaScript `MediaDeviceInfo` object, describing a single media input or output device.
 */
interface JsMediaDeviceInfo : JsObject {
    val deviceId: JsString get() = JsStringSyntax("${this}.deviceId")
    val kind: JsString get() = JsStringSyntax("${this}.kind")
    val label: JsString get() = JsStringSyntax("${this}.label")
    val groupId: JsString get() = JsStringSyntax("${this}.groupId")

    companion object {
        const val AUDIO_INPUT = "audioinput"
        const val AUDIO_OUTPUT = "audiooutput"
        const val VIDEO_INPUT = "videoinput"
    }
}