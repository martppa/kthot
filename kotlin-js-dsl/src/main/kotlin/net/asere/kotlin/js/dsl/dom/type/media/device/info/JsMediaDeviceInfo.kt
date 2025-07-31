package net.asere.kotlin.js.dsl.dom.type.media.device.info

import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.type.string.JsStringSyntax
import net.asere.kotlin.js.dsl.type.`object`.JsObject
import net.asere.kotlin.js.dsl.type.string.JsString

/**
 * Represents a JavaScript `MediaDeviceInfo` object, describing a single media input or output device.
 * This object is typically returned by methods like `navigator.mediaDevices.enumerateDevices()`.
 */
interface JsMediaDeviceInfo : JsObject {
    /**
     * Returns a unique identifier for the represented device as a [JsString] object.
     * This ID remains consistent across browsing sessions for the same device.
     *
     * In JavaScript, this corresponds to `mediaDeviceInfo.deviceId`.
     */
    val deviceId: JsString get() = JsStringSyntax(ChainOperation(this, "deviceId"))

    /**
     * Returns the kind of media device represented (e.g., "audioinput", "audiooutput", "videoinput")
     * as a [JsString] object.
     *
     * In JavaScript, this corresponds to `mediaDeviceInfo.kind`.
     */
    val kind: JsString get() = JsStringSyntax(ChainOperation(this, "kind"))

    /**
     * Returns a human-readable label for the device as a [JsString] object.
     * This might be an empty string if the user has not granted permission to access the device.
     *
     * In JavaScript, this corresponds to `mediaDeviceInfo.label`.
     */
    val label: JsString get() = JsStringSyntax(ChainOperation(this, "label"))

    /**
     * Returns a group identifier that remains consistent across devices sharing the same physical hardware
     * (e.g., a microphone and camera on the same webcam) as a [JsString] object.
     *
     * In JavaScript, this corresponds to `mediaDeviceInfo.groupId`.
     */
    val groupId: JsString get() = JsStringSyntax(ChainOperation(this, "groupId"))

    companion object {
        /**
         * Constant for `kind` property: Represents an audio input device (microphone).
         */
        const val AUDIO_INPUT = "audioinput"
        /**
         * Constant for `kind` property: Represents an audio output device (speaker).
         */
        const val AUDIO_OUTPUT = "audiooutput"
        /**
         * Constant for `kind` property: Represents a video input device (camera).
         */
        const val VIDEO_INPUT = "videoinput"
    }
}