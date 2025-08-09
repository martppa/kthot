package net.asere.kotlin.js.dsl.dom.type.event.keyboard

import net.asere.kotlin.js.dsl.dom.type.event.dom.JsDomEvent
import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.type.string.JsStringSyntax
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.JsBooleanSyntax
import net.asere.kotlin.js.dsl.type.bool.syntax
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.JsNumberSyntax
import net.asere.kotlin.js.dsl.type.number.syntax
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.syntax

/**
 * Represents a JavaScript `KeyboardEvent` object, which is dispatched when a key is pressed or released.
 * It extends [JsDomEvent] with properties specific to keyboard interactions.
 */
interface JsKeyboardEvent : JsDomEvent {
    /**
     * Returns the value of the key pressed by the user, taking into account the keyboard layout
     * (e.g., "a", "Enter", "ArrowUp") as a [JsString] object.
     *
     * In JavaScript, this corresponds to `event.key`.
     */
    val key: JsString get() = JsString.syntax(ChainOperation(this, "key"))

    /**
     * Returns a physical key code that identifies the physical key pressed,
     * independent of keyboard layout (e.g., "KeyA", "Enter", "ArrowUp") as a [JsString] object.
     *
     * In JavaScript, this corresponds to `event.code`.
     */
    val code: JsString get() = JsString.syntax(ChainOperation(this, "code"))

    /**
     * Returns a boolean indicating whether the key is being held down such that it is auto-repeating
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.repeat`.
     */
    val repeat: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "repeat"))

    /**
     * Returns a boolean indicating whether the event is part of a composition session
     * (e.g., for entering complex characters with an IME) as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.isComposing`.
     */
    val isComposing: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "isComposing"))

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

    /**
     * Returns the Unicode value of the character key pressed (for `keypress` events) as a [JsNumber] object.
     * This property is deprecated; use `key` instead.
     *
     * In JavaScript, this corresponds to `event.charCode`.
     */
    val charCode: JsNumber get() = JsNumber.syntax(ChainOperation(this, "charCode"))

    /**
     * Returns the Unicode value of the key pressed (for `keydown` and `keyup` events) as a [JsNumber] object.
     * This property is deprecated; use `key` or `code` instead.
     *
     * In JavaScript, this corresponds to `event.keyCode`.
     */
    val keyCode: JsNumber get() = JsNumber.syntax(ChainOperation(this, "keyCode"))

    /**
     * Returns the `keyCode` of the key that was pressed. This property is deprecated;
     * use `key` or `code` instead.
     *
     * In JavaScript, this corresponds to `event.which`.
     */
    val which: JsNumber get() = JsNumber.syntax(ChainOperation(this, "which"))

    companion object {
        /** Event type constant: Fired when a key is pressed down. */
        const val EVENT_KEYDOWN = "keydown"
        /** Event type constant: Fired when a key is released. */
        const val EVENT_KEYUP = "keyup"
        /** Event type constant: Fired when a key is pressed (generates a character). */
        const val EVENT_KEYPRESS = "keypress" // Deprecated for new code, but still common.
    }
}