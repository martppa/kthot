package net.asere.kthot.js.dsl.dom.type.window.screen

import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.obj.JsObject

/**
 * Represents the JavaScript `Screen` object, which contains information about the user's screen.
 *
 * This object is typically accessed via `window.screen`.
 */
interface JsScreen : JsObject {
    /**
     * Returns the width of the user's screen in pixels as a [JsNumber] object.
     * This value includes the operating system's taskbar, if any.
     *
     * In JavaScript, this corresponds to `screen.width`.
     */
    val width: JsNumber get() = JsNumber.syntax(ChainOperation(this, "width"))

    /**
     * Returns the height of the user's screen in pixels as a [JsNumber] object.
     * This value includes the operating system's taskbar, if any.
     *
     * In JavaScript, this corresponds to `screen.height`.
     */
    val height: JsNumber get() = JsNumber.syntax(ChainOperation(this, "height"))

    /**
     * Returns the width of the available screen space in pixels as a [JsNumber] object.
     * This value excludes permanent or semi-permanent user interface features like the operating system's taskbar.
     *
     * In JavaScript, this corresponds to `screen.availWidth`.
     */
    val availWidth: JsNumber get() = JsNumber.syntax(ChainOperation(this, "availWidth"))

    /**
     * Returns the height of the available screen space in pixels as a [JsNumber] object.
     * This value excludes permanent or semi-permanent user interface features like the operating system's taskbar.
     *
     * In JavaScript, this corresponds to `screen.availHeight`.
     */
    val availHeight: JsNumber get() = JsNumber.syntax(ChainOperation(this, "availHeight"))

    /**
     * Returns the color depth of the screen in bits per pixel as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `screen.colorDepth`.
     */
    val colorDepth: JsNumber get() = JsNumber.syntax(ChainOperation(this, "colorDepth"))

    /**
     * Returns the pixel depth of the screen in bits per pixel as a [JsNumber] object.
     * This is typically the same as `colorDepth`.
     *
     * In JavaScript, this corresponds to `screen.pixelDepth`.
     */
    val pixelDepth: JsNumber get() = JsNumber.syntax(ChainOperation(this, "pixelDepth"))

    companion object
}