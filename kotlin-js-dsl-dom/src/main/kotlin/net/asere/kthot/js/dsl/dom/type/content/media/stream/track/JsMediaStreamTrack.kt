package net.asere.kthot.js.dsl.dom.type.content.media.stream.track

import net.asere.kthot.js.dsl.dom.type.data.event.dom.JsDomEvent
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.js
import net.asere.kthot.js.dsl.type.bool.syntax
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.js
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents a JavaScript `MediaStreamTrack` object.
 * A `MediaStream` consists of zero or more `MediaStreamTrack` objects,
 * representing audio or video components (e.g., a microphone, a camera).
 */
interface JsMediaStreamTrack : JsObject {
    /**
     * Returns a unique identifier for the track as a [JsString] object.
     * This ID remains consistent across browsing sessions for the same track.
     *
     * In JavaScript, this corresponds to `mediaStreamTrack.id`.
     */
    val id: JsString get() = JsString.syntax(ChainOperation(this, "id"))

    /**
     * Returns the kind of media represented by the track (e.g., "audio", "video") as a [JsString] object.
     *
     * In JavaScript, this corresponds to `mediaStreamTrack.kind`.
     */
    val kind: JsString get() = JsString.syntax(ChainOperation(this, "kind"))

    /**
     * Returns a human-readable label for the track as a [JsString] object.
     * This might be an empty string if the user has not granted permission to access the device.
     *
     * In JavaScript, this corresponds to `mediaStreamTrack.label`.
     */
    val label: JsString get() = JsString.syntax(ChainOperation(this, "label"))

    /**
     * Returns or sets a boolean indicating whether the track is enabled (playing) as a [JsBoolean] object.
     * If `false`, the track's media is not being rendered.
     *
     * In JavaScript, this corresponds to `mediaStreamTrack.enabled`.
     */
    fun getEnabled(): JsBoolean = JsBoolean.syntax(ChainOperation(this, "enabled"))
    fun setEnabled(value: JsBoolean): JsSyntax =
        JsSyntax("${ChainOperation(this, "enabled")} = $value")

    fun setEnabled(value: Boolean): JsSyntax = setEnabled(value.js)

    /**
     * Returns a boolean indicating whether the track is muted (not producing data) as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `mediaStreamTrack.muted`.
     */
    val muted: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "muted"))

    /**
     * Returns the current state of the track as a [JsString] object.
     * Possible values: "live" (producing data), "ended" (no longer producing data).
     *
     * In JavaScript, this corresponds to `mediaStreamTrack.readyState`.
     */
    val readyState: JsString get() = JsString.syntax(ChainOperation(this, "readyState"))

    /**
     * Stops the track, effectively ending the media stream for this track.
     * This releases the underlying media source (e.g., camera, microphone).
     *
     * In JavaScript, this corresponds to `mediaStreamTrack.stop()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun stop(): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("stop")))

    /**
     * Clones the `MediaStreamTrack`. The cloned track will have a new unique ID.
     *
     * In JavaScript, this corresponds to `mediaStreamTrack.clone()`.
     * @return A [JsMediaStreamTrack] representing the cloned track.
     */
    fun clone(): JsMediaStreamTrack =
        JsMediaStreamTrack.syntax(ChainOperation(this, InvocationOperation("clone")))

    /**
     * Attaches an event listener to the track.
     *
     * @param event The name of the event to listen for (e.g., "ended", "mute") as a [JsString] object.
     * @param handler A [JsLambda1] representing the JavaScript function to execute when the event occurs.
     * The function typically receives a [JsDomEvent] object as its first argument.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun addEventListener(event: JsString, handler: JsLambda1<JsDomEvent>): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("addEventListener", event, handler)))

    fun addEventListener(event: String, handler: JsLambda1<JsDomEvent>): JsSyntax = addEventListener(event.js, handler)

    /**
     * Removes an event listener from the track.
     *
     * @param event The name of the event as a [JsString] object.
     * @param handler A [JsLambda1] representing the JavaScript function that was previously added.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun removeEventListener(event: JsString, handler: JsLambda1<JsDomEvent>): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("removeEventListener", event, handler)))

    fun removeEventListener(event: String, handler: JsLambda1<JsDomEvent>): JsSyntax =
        removeEventListener(event.js, handler)

    companion object {
        /**
         * Event type constant: Fired when the `MediaStreamTrack` has ended (e.g., due to the media source being disconnected).
         */
        const val EVENT_ENDED = "ended"

        /**
         * Event type constant: Fired when the `MediaStreamTrack` is muted (e.g., microphone turned off).
         */
        const val EVENT_MUTE = "mute"

        /**
         * Event type constant: Fired when the `MediaStreamTrack` is unmuted.
         */
        const val EVENT_UNMUTE = "unmute"

        /**
         * Event type constant: Fired when the `MediaStreamTrack`'s constraints cannot be satisfied.
         */
        const val EVENT_OVERCONSTRAINED = "overconstrained"
    }
}