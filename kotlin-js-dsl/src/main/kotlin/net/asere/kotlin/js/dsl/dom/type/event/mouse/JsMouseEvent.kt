package net.asere.kotlin.js.dsl.dom.type.event.mouse

import net.asere.kotlin.js.dsl.dom.type.event.dom.JsDomEvent
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.syntax
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.JsNumberSyntax

/**
 * Represents a JavaScript `MouseEvent` object, which is dispatched when a mouse event occurs
 * (e.g., click, mousemove, mouseover, mouseout, mousedown, mouseup).
 * It extends [JsDomEvent] with properties specific to mouse interactions.
 */
interface JsMouseEvent : JsDomEvent {
    /**
     * Returns the horizontal coordinate of the mouse pointer relative to the viewport's
     * content area (excluding scrollbars) as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.clientX`.
     */
    val clientX: JsNumber get() = JsNumberSyntax(ChainOperation(this, "clientX"))

    /**
     * Returns the vertical coordinate of the mouse pointer relative to the viewport's
     * content area (excluding scrollbars) as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.clientY`.
     */
    val clientY: JsNumber get() = JsNumberSyntax(ChainOperation(this, "clientY"))

    /**
     * Returns the horizontal coordinate of the mouse pointer relative to the whole document
     * (including parts scrolled out of view) as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.pageX`.
     */
    val pageX: JsNumber get() = JsNumberSyntax(ChainOperation(this, "pageX"))

    /**
     * Returns the vertical coordinate of the mouse pointer relative to the whole document
     * (including parts scrolled out of view) as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.pageY`.
     */
    val pageY: JsNumber get() = JsNumberSyntax(ChainOperation(this, "pageY"))

    /**
     * Returns the horizontal coordinate of the mouse pointer relative to the screen
     * as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.screenX`.
     */
    val screenX: JsNumber get() = JsNumberSyntax(ChainOperation(this, "screenX"))

    /**
     * Returns the vertical coordinate of the mouse pointer relative to the screen
     * as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.screenY`.
     */
    val screenY: JsNumber get() = JsNumberSyntax(ChainOperation(this, "screenY"))

    /**
     * Returns the button number pressed when the mouse event occurred
     * (0 for left, 1 for middle, 2 for right) as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.button`.
     */
    val button: JsNumber get() = JsNumberSyntax(ChainOperation(this, "button"))

    /**
     * Returns a number representing the state of the buttons pressed during a mouse event
     * (a bitmask: 1 for left, 2 for right, 4 for middle) as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.buttons`.
     */
    val buttons: JsNumber get() = JsNumberSyntax(ChainOperation(this, "buttons"))

    /**
     * Returns a boolean indicating if the `Alt` key was pressed when the event occurred
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.altKey`.
     */
    val altKey: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "altKey"))

    /**
     * Returns a boolean indicating if the `Control` key was pressed when the event occurred
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.ctrlKey`.
     */
    val ctrlKey: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "ctrlKey"))

    /**
     * Returns a boolean indicating if the `Shift` key was pressed when the event occurred
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.shiftKey`.
     */
    val shiftKey: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "shiftKey"))

    /**
     * Returns a boolean indicating if the `Meta` key (e.g., Command key on Mac, Windows key on Windows)
     * was pressed when the event occurred as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.metaKey`.
     */
    val metaKey: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "metaKey"))

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
    }
}