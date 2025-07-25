package net.asere.kotlin.js.dsl.dom.type.event

import net.asere.kotlin.js.dsl.syntax.value.JsBooleanSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.types.type.JsBoolean
import net.asere.kotlin.js.dsl.types.type.JsNumber

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
    val clientX: JsNumber get() = JsNumberSyntax("${this}.clientX")

    /**
     * Returns the vertical coordinate of the mouse pointer relative to the viewport's
     * content area (excluding scrollbars) as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.clientY`.
     */
    val clientY: JsNumber get() = JsNumberSyntax("${this}.clientY")

    /**
     * Returns the horizontal coordinate of the mouse pointer relative to the whole document
     * (including parts scrolled out of view) as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.pageX`.
     */
    val pageX: JsNumber get() = JsNumberSyntax("${this}.pageX")

    /**
     * Returns the vertical coordinate of the mouse pointer relative to the whole document
     * (including parts scrolled out of view) as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.pageY`.
     */
    val pageY: JsNumber get() = JsNumberSyntax("${this}.pageY")

    /**
     * Returns the horizontal coordinate of the mouse pointer relative to the screen
     * as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.screenX`.
     */
    val screenX: JsNumber get() = JsNumberSyntax("${this}.screenX")

    /**
     * Returns the vertical coordinate of the mouse pointer relative to the screen
     * as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.screenY`.
     */
    val screenY: JsNumber get() = JsNumberSyntax("${this}.screenY")

    /**
     * Returns the button number that was pressed when the mouse event occurred
     * (0 for left, 1 for middle, 2 for right) as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.button`.
     */
    val button: JsNumber get() = JsNumberSyntax("${this}.button")

    /**
     * Returns a number representing the state of the buttons pressed during a mouse event
     * (a bitmask: 1 for left, 2 for right, 4 for middle) as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.buttons`.
     */
    val buttons: JsNumber get() = JsNumberSyntax("${this}.buttons")

    /**
     * Returns a boolean indicating if the `Alt` key was pressed when the event occurred
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.altKey`.
     */
    val altKey: JsBoolean get() = JsBooleanSyntax("${this}.altKey")

    /**
     * Returns a boolean indicating if the `Control` key was pressed when the event occurred
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.ctrlKey`.
     */
    val ctrlKey: JsBoolean get() = JsBooleanSyntax("${this}.ctrlKey")

    /**
     * Returns a boolean indicating if the `Shift` key was pressed when the event occurred
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.shiftKey`.
     */
    val shiftKey: JsBoolean get() = JsBooleanSyntax("${this}.shiftKey")

    /**
     * Returns a boolean indicating if the `Meta` key (e.g., Command key on Mac, Windows key on Windows)
     * was pressed when the event occurred as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.metaKey`.
     */
    val metaKey: JsBoolean get() = JsBooleanSyntax("${this}.metaKey")

    companion object
}