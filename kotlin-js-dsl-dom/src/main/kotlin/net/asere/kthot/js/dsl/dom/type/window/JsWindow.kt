package net.asere.kthot.js.dsl.dom.type.window

import net.asere.kthot.js.dsl.dom.type.content.document.JsDocument
import net.asere.kthot.js.dsl.dom.type.content.document.syntax
import net.asere.kthot.js.dsl.dom.type.core.event.target.JsEventTargetRef
import net.asere.kthot.js.dsl.dom.type.window.Window.setInterval
import net.asere.kthot.js.dsl.dom.type.window.Window.setTimeout
import net.asere.kthot.js.dsl.dom.type.window.history.JsHistory
import net.asere.kthot.js.dsl.dom.type.window.history.syntax
import net.asere.kthot.js.dsl.dom.type.window.location.JsLocation
import net.asere.kthot.js.dsl.dom.type.window.location.syntax
import net.asere.kthot.js.dsl.dom.type.window.navigator.JsNavigator
import net.asere.kthot.js.dsl.dom.type.window.navigator.syntax
import net.asere.kthot.js.dsl.dom.type.window.screen.JsScreen
import net.asere.kthot.js.dsl.dom.type.window.screen.JsScreenSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.Undefined
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.syntax
import net.asere.kthot.js.dsl.type.lambda.l0.JsLambda0
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.js
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.JsStringRef
import net.asere.kthot.js.dsl.type.string.js
import net.asere.kthot.js.dsl.type.string.ref
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents the JavaScript `window` object, which is the global object in client-side JavaScript.
 * It is the root of the browser's JavaScript environment and the Document Object Model (DOM).
 * It inherits from [JsEventTarget] to allow for event handling (e.g., 'load', 'resize').
 */
object Window : JsEventTargetRef("window") {

    /**
     * Displays an alert box with a specified message and an OK button.
     * Corresponds to `window.alert(message)`.
     */
    fun alert(text: JsString): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("alert", text)))
    fun alert(text: String): JsSyntax = alert(text.js)

    /**
     * Displays a confirmation box with a specified message, an OK button, and a Cancel button.
     * Corresponds to `window.confirm(message)`.
     * @return A [JsBoolean] object representing the JavaScript boolean result (`true` if OK, `false` if Cancel).
     */
    fun confirm(text: JsString): JsBoolean = JsBoolean.syntax(ChainOperation(this, InvocationOperation("confirm", text)))
    fun confirm(text: String): JsBoolean = confirm(text.js)

    /**
     * Displays a dialog box that prompts the user for input.
     * Corresponds to `window.prompt(message, defaultValue)`.
     * @return A [JsString] object representing the user's input, or `null` if the user cancels the dialog.
     */
    fun prompt(text: JsString, defaultValue: JsString? = null): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("prompt", text, defaultValue ?: Undefined)))
    fun prompt(text: String, defaultValue: String? = null): JsString =
        prompt(text.js, defaultValue?.js)

    /**
     * Sets a timer which executes a function or specified piece of code once after the timer expires.
     * Corresponds to `window.setTimeout(handler, delay)`.
     * @param handler A [JsLambda0] object representing the function to be executed.
     * @return A [JsNumber] object representing the ID of the timer.
     */
    fun setTimeout(handler: JsLambda0, delay: JsNumber): JsNumber =
        JsNumber.syntax(ChainOperation(this, InvocationOperation("setTimeout", handler, delay)))

    /**
     * Repeatedly calls a function or executes a code snippet, with a fixed time delay between each call.
     * Corresponds to `window.setInterval(handler, delay)`.
     * @param handler A [JsLambda0] object representing the function to be executed.
     * @return A [JsNumber] object representing the ID of the interval.
     */
    fun setInterval(handler: JsLambda0, delay: JsNumber): JsNumber =
        JsNumber.syntax(ChainOperation(this, InvocationOperation("setInterval", handler, delay)))

    /**
     * Sets a timer which executes a block of code once after the timer expires.
     * Uses a standard Kotlin lambda for clean, readable syntax.
     * @param delay The time, in milliseconds, the timer should wait, as a [JsNumber] object.
     * @param handler The Kotlin lambda (`JsScope.() -> Unit`) containing the code to be executed.
     * @return A [JsNumber] object representing the ID of the timer.
     */
    fun setTimeout(delay: JsNumber, handler: JsScope.() -> Unit): JsNumber =
        JsNumber.syntax(
            ChainOperation(
                this,
                InvocationOperation(
                    leftSideElement = "setTimeout",
                    handler.js,
                    delay
                )
            )
        )

    /**
     * Sets a timer which executes a block of code once after the timer expires.
     * Convenience overload accepting a Kotlin [Int] for delay.
     */
    fun setTimeout(delay: Int, handler: JsScope.() -> Unit): JsNumber = setTimeout(delay.js, handler)


    /**
     * Repeatedly calls a block of code, with a fixed time delay between each call.
     * Uses a standard Kotlin lambda for clean, readable syntax.
     * @param delay The time, in milliseconds, the timer should wait between executions, as a [JsNumber] object.
     * @param handler The Kotlin lambda (`JsScope.() -> Unit`) containing the code to be executed repeatedly.
     * @return A [JsNumber] object representing the ID of the interval.
     */
    fun setInterval(delay: JsNumber, handler: JsScope.() -> Unit): JsNumber =
        JsNumber.syntax(
            ChainOperation(
                this,
                InvocationOperation(
                    leftSideElement = "setInterval",
                    handler.js,
                    delay
                )
            )
        )

    /**
     * Repeatedly calls a block of code, with a fixed time delay between each call.
     * Convenience overload accepting a Kotlin [Int] for delay.
     */
    fun setInterval(delay: Int, handler: JsScope.() -> Unit): JsNumber = setInterval(delay.js, handler)

    /**
     * Clears a timer set with [setTimeout].
     * Corresponds to `window.clearTimeout(timeoutId)`.
     */
    fun clearTimeout(timeoutId: JsNumber): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("clearTimeout", timeoutId)))
    fun clearTimeout(timeoutId: Int): JsSyntax = clearTimeout(timeoutId.js)

    /**
     * Clears an interval set with [setInterval].
     * Corresponds to `window.clearInterval(intervalId)`.
     */
    fun clearInterval(intervalId: JsNumber): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("clearInterval", intervalId)))
    fun clearInterval(intervalId: Int): JsSyntax = clearInterval(intervalId.js)

    /**
     * Returns the inner width of the browser window (viewport) in pixels.
     * Corresponds to `window.innerWidth`.
     */
    val innerWidth: JsNumber get() = JsNumber.syntax(ChainOperation(this, "innerWidth"))

    /**
     * Returns the inner height of the browser window (viewport) in pixels.
     * Corresponds to `window.innerHeight`.
     */
    val innerHeight: JsNumber get() = JsNumber.syntax(ChainOperation(this, "innerHeight"))

    /**
     * Returns the outer width of the browser window (including toolbars/scrollbars) in pixels.
     * Corresponds to `window.outerWidth`.
     */
    val outerWidth: JsNumber get() = JsNumber.syntax(ChainOperation(this, "outerWidth"))

    /**
     * Returns the outer height of the browser window (including toolbars/scrollbars) in pixels.
     * Corresponds to `window.outerHeight`.
     */
    val outerHeight: JsNumber get() = JsNumber.syntax(ChainOperation(this, "outerHeight"))

    /**
     * Returns the number of pixels the document has been scrolled horizontally.
     * Corresponds to `window.scrollX`.
     */
    val scrollX: JsNumber get() = JsNumber.syntax(ChainOperation(this, "scrollX"))

    /**
     * Returns the number of pixels the document has been scrolled vertically.
     * Corresponds to `window.scrollY`.
     */
    val scrollY: JsNumber get() = JsNumber.syntax(ChainOperation(this, "scrollY"))

    /**
     * Scrolls the document to the specified coordinates.
     * Corresponds to `window.scrollTo(x, y)`.
     */
    fun scrollTo(x: JsNumber, y: JsNumber): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("scrollTo", x, y)))
    fun scrollTo(x: Int, y: Int): JsSyntax = scrollTo(x.js, y.js)

    /**
     * Scrolls the document by the specified amount.
     * Corresponds to `window.scrollBy(x, y)`.
     */
    fun scrollBy(x: JsNumber, y: JsNumber): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("scrollBy", x, y)))
    fun scrollBy(x: Int, y: Int): JsSyntax = scrollBy(x.js, y.js)

    /**
     * Returns/sets the name of the window.
     * Corresponds to `window.name`.
     */
    val name: JsStringRef get() = JsString.ref(ChainOperation(this, "name"))

    /**
     * Returns a boolean indicating whether the window has been closed (read-only).
     * Corresponds to `window.closed`.
     */
    val closed: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "closed"))

    /**
     * Closes the current window.
     * Corresponds to `window.close()`.
     */
    fun close(): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("close")))

    /**
     * Opens a new browser window or tab.
     * Corresponds to `window.open(url, windowName, features)`.
     */
    fun open(url: JsString? = null, windowName: JsString? = null, features: JsString? = null): JsSyntax =
        JsSyntax(
            ChainOperation(
                this,
                InvocationOperation(
                    "open",
                    url ?: JsString.syntax("''"),
                    windowName ?: Undefined,
                    features ?: Undefined
                )
            )
        )
    fun open(url: String? = null, windowName: String? = null, features: String? = null): JsSyntax =
        open(url?.js, windowName?.js, features?.js)

    /**
     * Opens the Print Dialog to print the current document.
     * Corresponds to `window.print()`.
     */
    fun print(): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("print")))

    /**
     * Returns the [JsLocation] object, which contains information about the current URL.
     * Corresponds to `window.location`.
     */
    val location: JsLocation
        get() = JsLocation.syntax(ChainOperation(this, "location"))

    /**
     * Returns the [JsDocument] object, which is the root of the DOM tree.
     * Corresponds to `window.document`.
     */
    val document: JsDocument
        get() = JsDocument.syntax(ChainOperation(this, "document"))

    /**
     * Returns the [JsHistory] object, which provides access to the browser's session history.
     * Corresponds to `window.history`.
     */
    val history: JsHistory
        get() = JsHistory.syntax(ChainOperation(this, "history"))

    /**
     * Returns the [JsNavigator] object, which contains information about the web browser.
     * Corresponds to `window.navigator`.
     */
    val navigator: JsNavigator
        get() = JsNavigator.syntax(ChainOperation(this, "navigator"))

    /**
     * Returns the [JsScreen] object, which contains information about the user's screen.
     * Corresponds to `window.screen`.
     */
    val screen: JsScreen
        get() = JsScreenSyntax(ChainOperation(this, "screen"))

    /**
     * Returns the host (hostname plus port number) of the current URL (read-only).
     * Corresponds to `window.host`.
     */
    val host: JsString
        get() = JsString.syntax(ChainOperation(this, "host"))
}