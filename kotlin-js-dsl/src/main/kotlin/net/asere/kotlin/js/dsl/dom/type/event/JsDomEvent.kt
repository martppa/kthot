package net.asere.kotlin.js.dsl.dom.type.event

import net.asere.kotlin.js.dsl.dom.type.JsDomObject
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsBooleanSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsDomObjectSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.types.type.JsBoolean
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.JsString

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
    val type: JsString get() = JsStringSyntax("${this}.type")

    /**
     * Returns the element that originally dispatched the event (the most deeply nested element)
     * as a [JsDomObject] object.
     *
     * In JavaScript, this corresponds to `event.target`.
     */
    val target: JsDomObject get() = JsDomObjectSyntax("${this}.target")

    /**
     * Returns the element to which the event listener was attached (the current target during bubbling)
     * as a [JsDomObject] object.
     *
     * In JavaScript, this corresponds to `event.currentTarget`.
     */
    val currentTarget: JsDomObject get() = JsDomObjectSyntax("${this}.currentTarget")

    /**
     * Returns the time (in milliseconds since the epoch) at which the event was created as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `event.timeStamp`.
     */
    val timeStamp: JsNumber get() = JsNumberSyntax("${this}.timeStamp")

    /**
     * Returns a boolean indicating whether the event bubbles up through the DOM tree as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.bubbles`.
     */
    val bubbles: JsBoolean get() = JsBooleanSyntax("${this}.bubbles")

    /**
     * Returns a boolean indicating whether the event is cancelable (i.e., its default action can be prevented)
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.cancelable`.
     */
    val cancelable: JsBoolean get() = JsBooleanSyntax("${this}.cancelable")

    /**
     * Returns a boolean indicating whether the default action of the event has been prevented
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.defaultPrevented`.
     */
    val defaultPrevented: JsBoolean get() = JsBooleanSyntax("${this}.defaultPrevented")

    /**
     * Prevents the default action of the event from occurring.
     * For example, preventing a link from navigating or a form from submitting.
     *
     * In JavaScript, this corresponds to `event.preventDefault()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun preventDefault(): JsSyntax = JsSyntax("${this}.preventDefault()")

    /**
     * Stops the propagation of the event up the DOM tree.
     * This prevents the event from reaching parent elements' event listeners.
     *
     * In JavaScript, this corresponds to `event.stopPropagation()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun stopPropagation(): JsSyntax = JsSyntax("${this}.stopPropagation()")

    /**
     * Stops the propagation of the event up the DOM tree and prevents any other event listeners
     * on the *current* element from being called for the current event.
     *
     * In JavaScript, this corresponds to `event.stopImmediatePropagation()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun stopImmediatePropagation(): JsSyntax = JsSyntax("${this}.stopImmediatePropagation()")

    companion object
}