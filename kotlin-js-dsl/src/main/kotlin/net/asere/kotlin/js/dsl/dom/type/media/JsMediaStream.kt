package net.asere.kotlin.js.dsl.dom.type.media

import net.asere.kotlin.js.dsl.dom.syntax.media.JsMediaStreamSyntax
import net.asere.kotlin.js.dsl.dom.syntax.media.JsMediaStreamTrackSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.value.JsArraySyntax
import net.asere.kotlin.js.dsl.syntax.value.JsBooleanSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.types.type.*

/**
 * Represents a JavaScript `MediaStream` object, which is a stream of media content.
 * A `MediaStream` consists of zero or more `MediaStreamTrack` objects,
 * representing audio or video components.
 */
interface JsMediaStream : JsObject {
    /**
     * Returns a unique identifier for the stream as a [JsString] object.
     *
     * In JavaScript, this corresponds to `mediaStream.id`.
     */
    val id: JsString get() = JsStringSyntax(ChainOperation(this, "id"))

    /**
     * Returns a boolean indicating whether the stream is active (has at least one active track)
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `mediaStream.active`.
     */
    val active: JsBoolean get() = JsBooleanSyntax(ChainOperation(this, "active"))

    /**
     * Returns a [JsArray] of all `MediaStreamTrack` objects in the stream that have `kind` set to "audio".
     *
     * In JavaScript, this corresponds to `stream.getAudioTracks()`.
     * @return A [JsArray] of [JsMediaStreamTrack] objects.
     */
    fun getAudioTracks(): JsArray<JsMediaStreamTrack> =
        JsArraySyntax(ChainOperation(this, "getAudioTracks()"))

    /**
     * Returns a [JsArray] of all `MediaStreamTrack` objects in the stream that have `kind` set to "video".
     *
     * In JavaScript, this corresponds to `stream.getVideoTracks()`.
     * @return A [JsArray] of [JsMediaStreamTrack] objects.
     */
    fun getVideoTracks(): JsArray<JsMediaStreamTrack> =
        JsArraySyntax(ChainOperation(this, "getVideoTracks()"))

    /**
     * Returns a [JsArray] of all `MediaStreamTrack` objects in the stream, regardless of their kind.
     *
     * In JavaScript, this corresponds to `stream.getTracks()`.
     * @return A [JsArray] of [JsMediaStreamTrack] objects.
     */
    fun getTracks(): JsArray<JsMediaStreamTrack> =
        JsArraySyntax(ChainOperation(this, "getTracks()"))

    /**
     * Returns a single `MediaStreamTrack` from the stream whose `id` matches the given string.
     *
     * In JavaScript, this corresponds to `stream.getTrackById(trackId)`.
     * @param trackId The ID of the track to retrieve as a [JsString] object.
     * @return A [JsMediaStreamTrack] object if found, otherwise `null`.
     */
    fun getTrackById(trackId: JsString): JsMediaStreamTrack =
        JsMediaStreamTrackSyntax(ChainOperation(this, "getTrackById($trackId)"))

    fun getTrackById(trackId: String): JsMediaStreamTrack = getTrackById(trackId.js)

    /**
     * Adds a `MediaStreamTrack` to the stream.
     *
     * In JavaScript, this corresponds to `stream.addTrack(track)`.
     * @param track The [JsMediaStreamTrack] to add to the stream.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun addTrack(track: JsMediaStreamTrack): JsSyntax = JsSyntax(ChainOperation(this, "addTrack($track)"))

    /**
     * Removes a `MediaStreamTrack` from the stream.
     *
     * In JavaScript, this corresponds to `stream.removeTrack(track)`.
     * @param track The [JsMediaStreamTrack] to remove from the stream.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun removeTrack(track: JsMediaStreamTrack): JsSyntax = JsSyntax(ChainOperation(this, "removeTrack($track)"))

    /**
     * Clones the `MediaStream`. All its `MediaStreamTrack`s are also cloned.
     *
     * In JavaScript, this corresponds to `stream.clone()`.
     * @return A new [JsMediaStream] object that is a clone of the original.
     */
    fun clone(): JsMediaStream = JsMediaStreamSyntax(ChainOperation(this, "clone()"))
}