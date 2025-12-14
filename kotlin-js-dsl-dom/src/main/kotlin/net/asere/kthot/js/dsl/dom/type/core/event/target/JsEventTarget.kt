package net.asere.kthot.js.dsl.dom.type.core.event.target

import net.asere.kthot.js.dsl.dom.type.data.event.dom.JsDomEvent
import net.asere.kthot.js.dsl.dom.type.data.event.dom.syntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.js

/**
 * Represents the base interface for any object that can be a target of events
 * in the DOM (e.g., Element, Document, Window). Extends the base JsObject.
 */
interface JsEventTarget : JsObject {

    /**
     * Attaches an event listener to the EventTarget. When the specified event occurs,
     * the provided handler function will be executed.
     *
     * In JavaScript, this corresponds to `element.addEventListener(event, handler)`.
     * @param event The name of the event to listen for (e.g., "load", "resize") as a [JsString] object.
     * @param handler A [JsLambda1] representing the JavaScript function to execute when the event occurs.
     * The function typically receives a [JsDomEvent] object as its first argument.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun addEventListener(event: JsString, handler: JsLambda1<JsDomEvent>): JsSyntax =
        JsSyntax(ChainOperation(this, "addEventListener($event, $handler)"))

    fun addEventListener(event: JsString, handler: JsScope.(JsDomEvent) -> Unit): JsSyntax =
        JsSyntax(
            ChainOperation(
                leftHand = this,
                rightHand = InvocationOperation(
                    leftSideElement = "addEventListener",
                    event, handler.js(JsDomEvent::syntax)
                )
            )
        )

    /**
     * Attaches an event listener to the EventTarget.
     * This is a convenience overload for [addEventListener] that accepts a Kotlin [String] for the event name.
     *
     * @param event The name of the event to listen for as a Kotlin [String].
     * @param handler A [JsLambda1] representing the JavaScript function to execute.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun addEventListener(event: String, handler: JsLambda1<JsDomEvent>): JsSyntax = addEventListener(event.js, handler)

    fun addEventListener(event: String, handler: JsScope.(JsDomEvent) -> Unit): JsSyntax =
        addEventListener(event.js, handler)

    /**
     * Removes an event listener from the EventTarget.
     * The `handler` function must be the *exact same function instance* that was originally added.
     *
     * In JavaScript, this corresponds to `element.removeEventListener(event, handler)`.
     * @param event The name of the event as a [JsString] object.
     * @param handler A [JsLambda1] representing the JavaScript function that was previously added.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun removeEventListener(event: JsString, handler: JsLambda1<JsDomEvent>): JsSyntax =
        JsSyntax(ChainOperation(this, "removeEventListener($event, $handler)"))

    /**
     * Removes an event listener from the EventTarget.
     * This is a convenience overload for [removeEventListener] that accepts a Kotlin [String] for the event name.
     *
     * @param event The name of the event as a Kotlin [String].
     * @param handler A [JsLambda1] representing the JavaScript function that was previously added.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun removeEventListener(event: String, handler: JsLambda1<JsDomEvent>): JsSyntax =
        removeEventListener(event.js, handler)

    /**
     * Dispatches an Event at the specified EventTarget, invoking the listeners.
     * Corresponds to `target.dispatchEvent(event)`.
     * @param event A [JsObject] representing the Event object to dispatch.
     * @return A [JsObject] (Boolean) indicating whether the event was canceled.
     */
    fun dispatchEvent(event: JsObject): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("dispatchEvent", event)))

    companion object
}