package net.asere.kotlin.js.dsl.dom.type.media

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.value.JsPromiseSyntax
import net.asere.kotlin.js.dsl.types.type.JsArray
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.JsPromise

/**
 * Represents the JavaScript `MediaDevices` object, providing access to connected media input devices
 * like cameras and microphones, as well as screen sharing.
 * This object is typically accessed via `navigator.mediaDevices`.
 */
interface JsMediaDevices : JsObject {

    /**
     * Prompts the user for permission to use a media input (e.g., camera, microphone)
     * and returns a [JsPromise] that resolves with a [JsMediaStream] object if successful.
     *
     * In JavaScript, this corresponds to `navigator.mediaDevices.getUserMedia(constraints)`.
     * @param constraints A [JsSyntax] object representing [JsMediaStreamConstraint] for the requested media.
     * @return A [JsPromise] that resolves with a [JsMediaStream] or rejects with an error.
     */
    fun getUserMedia(constraints: JsSyntax): JsPromise<JsMediaStream> = JsPromiseSyntax(ChainOperation(this, "getUserMedia(${constraints})"))

    /**
     * Enumerates the available media input and output devices (e.g., cameras, microphones, speakers).
     * Returns a [JsPromise] that resolves with an array of [JsMediaDeviceInfo] objects.
     *
     * In JavaScript, this corresponds to `navigator.mediaDevices.enumerateDevices()`.
     * @return A [JsPromise] that resolves with a [JsArray] of [JsMediaDeviceInfo].
     */
    fun enumerateDevices(): JsPromise<JsArray<JsMediaDeviceInfo>> = JsPromiseSyntax(ChainOperation(this, "enumerateDevices()"))

    /**
     * Prompts the user to select a display or application window to capture (screen sharing).
     * Returns a [JsPromise] that resolves with a [JsMediaStream] object containing the display media.
     *
     * In JavaScript, this corresponds to `navigator.mediaDevices.getDisplayMedia(constraints)`.
     * @param constraints A [JsSyntax] object representing [JsMediaStreamConstraint] for the requested display media.
     * @return A [JsPromise] that resolves with a [JsMediaStream] or rejects with an error.
     */
    fun getDisplayMedia(constraints: JsSyntax): JsPromise<JsMediaStream> = JsPromiseSyntax(ChainOperation(this, "getDisplayMedia(${constraints})"))
}