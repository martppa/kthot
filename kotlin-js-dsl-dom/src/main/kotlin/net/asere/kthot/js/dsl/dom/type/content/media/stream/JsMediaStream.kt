package net.asere.kthot.js.dsl.dom.type.content.media.stream

import net.asere.kthot.js.dsl.dom.type.content.media.stream.track.JsMediaStreamTrack
import net.asere.kthot.js.dsl.dom.type.content.media.stream.track.syntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.array.syntax
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.syntax
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.js
import net.asere.kthot.js.dsl.type.string.syntax

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
    val id: JsString get() = JsString.syntax(ChainOperation(this, "id"))

    /**
     * Returns a boolean indicating whether the stream is active (has at least one active track)
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `mediaStream.active`.
     */
    val active: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "active"))

    /**
     * Returns a [net.asere.kthot.js.dsl.type.array.JsArray] of all `MediaStreamTrack` objects in the stream that have `kind` set to "audio".
     *
     * In JavaScript, this corresponds to `stream.getAudioTracks()`.
     * @return A [net.asere.kthot.js.dsl.type.array.JsArray] of [JsMediaStreamTrack] objects.
     */
    fun getAudioTracks(): JsArray<JsMediaStreamTrack> =
        JsArray.syntax(
            typeBuilder = JsMediaStreamTrack::syntax,
            value = ChainOperation(this, InvocationOperation("getAudioTracks")),
        )

    /**
     * Returns a [JsArray] of all `MediaStreamTrack` objects in the stream that have `kind` set to "video".
     *
     * In JavaScript, this corresponds to `stream.getVideoTracks()`.
     * @return A [JsArray] of [JsMediaStreamTrack] objects.
     */
    fun getVideoTracks(): JsArray<JsMediaStreamTrack> =
        JsArray.syntax(
            typeBuilder = JsMediaStreamTrack::syntax,
            value = ChainOperation(this, InvocationOperation("getVideoTracks"))
        )

    /**
     * Returns a [JsArray] of all `MediaStreamTrack` objects in the stream, regardless of their kind.
     *
     * In JavaScript, this corresponds to `stream.getTracks()`.
     * @return A [JsArray] of [JsMediaStreamTrack] objects.
     */
    fun getTracks(): JsArray<JsMediaStreamTrack> =
        JsArray.syntax(
            typeBuilder = JsMediaStreamTrack::syntax,
            value = ChainOperation(this, InvocationOperation("getTracks"))
        )

    /**
     * Returns a single `MediaStreamTrack` from the stream whose `id` matches the given string.
     *
     * In JavaScript, this corresponds to `stream.getTrackById(trackId)`.
     * @param trackId The ID of the track to retrieve as a [JsString] object.
     * @return A [JsMediaStreamTrack] object if found, otherwise `null`.
     */
    fun getTrackById(trackId: JsString): JsMediaStreamTrack =
        JsMediaStreamTrack.syntax(ChainOperation(this, InvocationOperation("getTrackById", trackId)))

    fun getTrackById(trackId: String): JsMediaStreamTrack = getTrackById(trackId.js)

    /**
     * Adds a `MediaStreamTrack` to the stream.
     *
     * In JavaScript, this corresponds to `stream.addTrack(track)`.
     * @param track The [JsMediaStreamTrack] to add to the stream.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun addTrack(track: JsMediaStreamTrack): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("addTrack", track)))

    /**
     * Removes a `MediaStreamTrack` from the stream.
     *
     * In JavaScript, this corresponds to `stream.removeTrack(track)`.
     * @param track The [JsMediaStreamTrack] to remove from the stream.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun removeTrack(track: JsMediaStreamTrack): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("removeTrack", track)))

    /**
     * Clones the `MediaStream`. All its `MediaStreamTrack`s are also cloned.
     *
     * In JavaScript, this corresponds to `stream.clone()`.
     * @return A new [JsMediaStream] object that is a clone of the original.
     */
    fun clone(): JsMediaStream =
        JsMediaStream.syntax(ChainOperation(this, InvocationOperation("clone")))

    companion object
}