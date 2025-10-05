package net.asere.kthot.js.dsl.dom.type.content.media.device

import net.asere.kthot.js.dsl.dom.type.content.media.device.info.JsMediaDeviceInfo
import net.asere.kthot.js.dsl.dom.type.content.media.stream.JsMediaStream
import net.asere.kthot.js.dsl.dom.type.content.media.stream.constraint.JsMediaStreamConstraint
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.syntax

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
     * @param constraints A [net.asere.kthot.js.dsl.syntax.JsSyntax] object representing [JsMediaStreamConstraint] for the requested media.
     * @return A [JsPromise] that resolves with a [net.asere.kthot.js.dsl.dom.type.media.stream.JsMediaStream] or rejects with an error.
     */
    fun getUserMedia(constraints: JsSyntax): JsPromise<JsMediaStream> =
        JsPromise.syntax(ChainOperation(this, "getUserMedia(${constraints})"))

    /**
     * Enumerates the available media input and output devices (e.g., cameras, microphones, speakers).
     * Returns a [JsPromise] that resolves with an array of [JsMediaDeviceInfo] objects.
     *
     * In JavaScript, this corresponds to `navigator.mediaDevices.enumerateDevices()`.
     * @return A [JsPromise] that resolves with a [JsArray] of [JsMediaDeviceInfo].
     */
    fun enumerateDevices(): JsPromise<JsArray<JsMediaDeviceInfo>> =
        JsPromise.syntax(ChainOperation(this, "enumerateDevices()"))

    /**
     * Prompts the user to select a display or application window to capture (screen sharing).
     * Returns a [JsPromise] that resolves with a [JsMediaStream] object containing the display media.
     *
     * In JavaScript, this corresponds to `navigator.mediaDevices.getDisplayMedia(constraints)`.
     * @param constraints A [JsSyntax] object representing [JsMediaStreamConstraint] for the requested display media.
     * @return A [JsPromise] that resolves with a [JsMediaStream] or rejects with an error.
     */
    fun getDisplayMedia(constraints: JsMediaStreamConstraint): JsPromise<JsMediaStream> =
        JsPromise.syntax(ChainOperation(this, InvocationOperation("getDisplayMedia", constraints)))

    companion object
}