package net.asere.kthot.js.dsl.dom.type.data.event.dom

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.dom.type.core.event.target.JsEventTarget
import net.asere.kthot.js.dsl.dom.type.core.event.target.syntax
import net.asere.kthot.js.dsl.syntax
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.array.syntax
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.syntax
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents the JavaScript `Event` interface. This is the base interface for all events fired
 * in the DOM (e.g., click, change, keydown) and is inherited from [JsEventTarget].
 */
interface JsDomEvent : JsEventTarget {

    /**
     * The name identifying the type of the event (e.g., "click", "keydown").
     * Corresponds to `event.type`.
     */
    val type: JsString
        get() = JsString.syntax(ChainOperation(this, "type"))

    /**
     * A reference to the object to which the event was originally dispatched.
     * Corresponds to `event.target`.
     */
    val target: JsEventTarget
        get() = JsEventTarget.syntax(ChainOperation(this, "target"))

    /**
     * A reference to the currently registered target for the event (the element the listener was attached to).
     * Corresponds to `event.currentTarget`.
     */
    val currentTarget: JsEventTarget
        get() = JsEventTarget.syntax(ChainOperation(this, "currentTarget"))

    /**
     * A boolean value indicating whether or not the event bubbles up through the DOM.
     * Corresponds to `event.bubbles`.
     */
    val bubbles: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "bubbles"))

    /**
     * A boolean value indicating whether the event is cancelable.
     * Corresponds to `event.cancelable`.
     */
    val cancelable: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "cancelable"))

    /**
     * Indicates which phase of the event flow is being processed. (1=Capturing, 2=At Target, 3=Bubbling).
     * Corresponds to `event.eventPhase`.
     */
    val eventPhase: JsNumber
        get() = JsNumber.syntax(ChainOperation(this, "eventPhase"))

    /**
     * Indicates whether or not the event was initiated by the browser (user action) or a script.
     * Corresponds to `event.isTrusted`.
     */
    val isTrusted: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "isTrusted"))

    /**
     * Indicates whether or not the call to `event.preventDefault()` canceled the event.
     * Corresponds to `event.defaultPrevented`.
     */
    val defaultPrevented: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "defaultPrevented"))

    /**
     * A boolean indicating whether or not the event can bubble across the boundary between shadow DOM and the regular DOM.
     * Corresponds to `event.composed`.
     */
    val composed: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "composed"))

    /**
     * The time at which the event was created (in milliseconds).
     * Corresponds to `event.timeStamp`.
     */
    val timeStamp: JsNumber
        get() = JsNumber.syntax(ChainOperation(this, "timeStamp"))

    /**
     * Cancels the event (if it is cancelable), preventing the browser's default action.
     * Corresponds to `event.preventDefault()`.
     */
    fun preventDefault(): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("preventDefault")))

    /**
     * Stops the propagation of events further along in the DOM tree (prevents bubbling/capturing to ancestors/descendants).
     * Corresponds to `event.stopPropagation()`.
     */
    fun stopPropagation(): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("stopPropagation")))

    /**
     * Prevents all other listeners from being called for this event, including listeners on the same element.
     * Corresponds to `event.stopImmediatePropagation()`.
     */
    fun stopImmediatePropagation(): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("stopImmediatePropagation")))

    /**
     * Returns the event's path (an array of objects on which listeners will be invoked).
     * Corresponds to `event.composedPath()`.
     */
    fun composedPath(): JsArray<JsEventTarget> =
        JsArray.syntax(ChainOperation(this, InvocationOperation("composedPath")))

    /**
     * Deprecated alias for [JsDomEvent.target]. Use [JsDomEvent.target] instead.
     * Corresponds to `event.srcElement`.
     */
    val srcElement: JsEventTarget
        get() = JsEventTarget.syntax(ChainOperation(this, "srcElement"))

    companion object {
        const val NONE: Int = 0
        const val CAPTURING_PHASE: Int = 1
        const val AT_TARGET: Int = 2
        const val BUBBLING_PHASE: Int = 3
        /** Event type constant: Fired when an element is clicked. */
        const val EVENT_CLICK = "click"
        /** Event type constant: Fired when a user double-clicks an element. */
        const val EVENT_DBLCLICK = "dblclick"
        /** Event type constant: Fired when a pointer device button is pressed over an element. */
        const val EVENT_MOUSEDOWN = "mousedown"
        /** Event type constant: Fired when a pointer device button is released over an element. */
        const val EVENT_MOUSEUP = "mouseup"
        /** Event type constant: Fired when a pointer is moved onto an element or one of its children. */
        const val EVENT_MOUSEOVER = "mouseover"
        /** Event type constant: Fired when a pointer is moved off an element or one of its children. */
        const val EVENT_MOUSEOUT = "mouseout"
        /** Event type constant: Fired when a pointer is moved while it is over an element. */
        const val EVENT_MOUSEMOVE = "mousemove"
        /** Event type constant: Fired when the mouse wheel is rotated. */
        const val EVENT_WHEEL = "wheel"
        /** Event type constant: Fired when a key is pressed down. */
        const val EVENT_KEYDOWN = "keydown"
        /** Event type constant: Fired when a key is released. */
        const val EVENT_KEYUP = "keyup"
        /** Event type constant: Fired when a key is pressed (generates a character). */
        const val EVENT_KEYPRESS = "keypress"
        /** Event type constant: Fired when an element gains focus. */
        const val EVENT_FOCUS = "focus"
        /** Event type constant: Fired when an element loses focus. */
        const val EVENT_BLUR = "blur"
        /** Event type constant: Fired when the value of an <input>, <select>, or <textarea> element has been changed. */
        const val EVENT_CHANGE = "change"
        /** Event type constant: Fired when a form is submitted. */
        const val EVENT_SUBMIT = "submit"
        /** Event type constant: Fired when a user resets a form. */
        const val EVENT_RESET = "reset"
        /** Event type constant: Fired when a document or a resource has finished loading. */
        const val EVENT_LOAD = "load"
        /** Event type constant: Fired when a document or a resource is about to be unloaded. */
        const val EVENT_UNLOAD = "unload"
        /** Event type constant: Fired when the window has been resized. */
        const val EVENT_RESIZE = "resize"
        /** Event type constant: Fired when the document view has been scrolled. */
        const val EVENT_SCROLL = "scroll"
        /** Event type constant: Fired when an error occurs during the loading of a resource. */
        const val EVENT_ERROR = "error"
        /** Event type constant: Fired when an element or its content has been changed. */
        const val EVENT_INPUT = "input"
        /** Event type constant: Fired when the value of an element is selected. */
        const val EVENT_SELECT = "select"
        /** Event type constant: Fired when an element's context menu is requested. */
        const val EVENT_CONTEXTMENU = "contextmenu"
        /** Event type constant: Fired when a touch point is placed on the touch surface. */
        const val EVENT_TOUCHSTART = "touchstart"
        /** Event type constant: Fired when a touch point is moved along the touch surface. */
        const val EVENT_TOUCHMOVE = "touchmove"
        /** Event type constant: Fired when a touch point is removed from the touch surface. */
        const val EVENT_TOUCHEND = "touchend"
        /** Event type constant: Fired when a touch point has been disrupted. */
        const val EVENT_TOUCHCANCEL = "touchcancel"
    }
}