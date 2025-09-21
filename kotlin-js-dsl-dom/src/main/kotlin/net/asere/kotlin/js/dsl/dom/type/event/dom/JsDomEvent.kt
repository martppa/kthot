package net.asere.kotlin.js.dsl.dom.type.event.dom

import net.asere.kotlin.js.dsl.dom.type.obj.JsDomObject
import net.asere.kotlin.js.dsl.dom.type.obj.syntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.syntax
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.JsNumberSyntax
import net.asere.kotlin.js.dsl.type.number.syntax
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.syntax

/**
 * Represents the base JavaScript `Event` object, which is passed to event listeners
 * when an event occurs in the DOM.
 *
 * This interface provides common properties and methods available on all standard DOM events.
 */
interface JsDomEvent : JsObject {
    /**
     * Returns the type of the event (e.g., "click", "mouseover", "keydown") as a [JsString] object.
     *
     * In JavaScript, this corresponds to `event.type`.
     */
    val type: JsString get() = JsString.syntax(ChainOperation(this, "type"))

    /**
     * Returns the element that originally dispatched the event (the most deeply nested element)
     * as a [JsDomObject] object.
     *
     * In JavaScript, this corresponds to `event.target`.
     */
    val target: JsDomObject get() = JsDomObject.syntax(ChainOperation(this, "target"))

    /**
     * Returns the element to which the event listener was attached (the current target during bubbling)
     * as a [JsDomObject] object.
     *
     * In JavaScript, this corresponds to `event.currentTarget`.
     */
    val currentTarget: JsDomObject get() = JsDomObject.syntax(ChainOperation(this, "currentTarget"))

    /**
     * Returns the time (in milliseconds since the epoch) at which the event was created as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.timeStamp`.
     */
    val timeStamp: JsNumber get() = JsNumber.syntax(ChainOperation(this, "timeStamp"))

    /**
     * Returns a boolean indicating whether the event bubbles up through the DOM tree as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.bubbles`.
     */
    val bubbles: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "bubbles"))

    /**
     * Returns a boolean indicating whether the event is cancelable (i.e., its default action can be prevented)
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.cancelable`.
     */
    val cancelable: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "cancelable"))

    /**
     * Returns a boolean indicating whether the default action of the event has been prevented
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.defaultPrevented`.
     */
    val defaultPrevented: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "defaultPrevented"))

    /**
     * Prevents the default action of the event from occurring.
     * For example, preventing a link from navigating or a form from submitting.
     *
     * In JavaScript, this corresponds to `event.preventDefault()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun preventDefault(): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("preventDefault")))

    /**
     * Stops the propagation of the event up the DOM tree.
     * This prevents the event from reaching parent elements' event listeners.
     *
     * In JavaScript, this corresponds to `event.stopPropagation()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun stopPropagation(): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("stopPropagation")))

    /**
     * Stops the propagation of the event up the DOM tree and prevents any other event listeners
     * on the *current* element from being called for the current event.
     *
     * In JavaScript, this corresponds to `event.stopImmediatePropagation()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun stopImmediatePropagation(): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("stopImmediatePropagation")))

    companion object {
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