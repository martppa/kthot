package net.asere.kotlin.js.dsl.dom.type.event

import net.asere.kotlin.js.dsl.syntax.value.JsBooleanSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.types.type.JsBoolean
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.JsString

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
    val key: JsString get() = JsStringSyntax("${this}.key")

    /**
     * Returns a physical key code that identifies the physical key pressed,
     * independent of keyboard layout (e.g., "KeyA", "Enter", "ArrowUp") as a [JsString] object.
     *
     * In JavaScript, this corresponds to `event.code`.
     */
    val code: JsString get() = JsStringSyntax("${this}.code")

    /**
     * Returns a boolean indicating whether the key is being held down such that it is auto-repeating
     * as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.repeat`.
     */
    val repeat: JsBoolean get() = JsBooleanSyntax("${this}.repeat")

    /**
     * Returns a boolean indicating whether the event is part of a composition session
     * (e.g., for entering complex characters with an IME) as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `event.isComposing`.
     */
    val isComposing: JsBoolean get() = JsBooleanSyntax("${this}.isComposing")

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

    /**
     * Returns the Unicode value of the character key pressed (for `keypress` events) as a [JsNumber] object.
     * This property is deprecated; use `key` instead.
     *
     * In JavaScript, this corresponds to `event.charCode`.
     */
    val charCode: JsNumber get() = JsNumberSyntax("${this}.charCode")

    /**
     * Returns the Unicode value of the key pressed (for `keydown` and `keyup` events) as a [JsNumber] object.
     * This property is deprecated; use `key` or `code` instead.
     *
     * In JavaScript, this corresponds to `event.keyCode`.
     */
    val keyCode: JsNumber get() = JsNumberSyntax("${this}.keyCode")

    /**
     * Returns the `keyCode` of the key that was pressed. This property is deprecated;
     * use `key` or `code` instead.
     *
     * In JavaScript, this corresponds to `event.which`.
     */
    val which: JsNumber get() = JsNumberSyntax("${this}.which")

    companion object
}