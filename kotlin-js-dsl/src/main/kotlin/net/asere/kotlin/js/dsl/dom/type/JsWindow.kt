package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.dom.type.Window.addEventListener
import net.asere.kotlin.js.dsl.dom.type.Window.alert
import net.asere.kotlin.js.dsl.dom.type.Window.clearInterval
import net.asere.kotlin.js.dsl.dom.type.Window.clearTimeout
import net.asere.kotlin.js.dsl.dom.type.Window.confirm
import net.asere.kotlin.js.dsl.dom.type.Window.open
import net.asere.kotlin.js.dsl.dom.type.Window.prompt
import net.asere.kotlin.js.dsl.dom.type.Window.removeEventListener
import net.asere.kotlin.js.dsl.dom.type.Window.scrollBy
import net.asere.kotlin.js.dsl.dom.type.Window.scrollTo
import net.asere.kotlin.js.dsl.dom.type.Window.setInterval
import net.asere.kotlin.js.dsl.dom.type.Window.setName
import net.asere.kotlin.js.dsl.dom.type.Window.setTimeout
import net.asere.kotlin.js.dsl.dom.type.document.JsDocument
import net.asere.kotlin.js.dsl.dom.type.document.JsDocumentSyntax
import net.asere.kotlin.js.dsl.dom.type.event.dom.JsDomEvent
import net.asere.kotlin.js.dsl.dom.type.history.JsHistory
import net.asere.kotlin.js.dsl.dom.type.history.JsHistorySyntax
import net.asere.kotlin.js.dsl.dom.type.location.JsLocation
import net.asere.kotlin.js.dsl.dom.type.location.JsLocationSyntax
import net.asere.kotlin.js.dsl.dom.type.navigator.JsNavigator
import net.asere.kotlin.js.dsl.dom.type.navigator.JsNavigatorSyntax
import net.asere.kotlin.js.dsl.dom.type.screen.JsScreen
import net.asere.kotlin.js.dsl.dom.type.screen.JsScreenSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.JsBooleanSyntax
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.js
import net.asere.kotlin.js.dsl.type.obj.JsObjectRef
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.JsStringSyntax
import net.asere.kotlin.js.dsl.type.string.js
import net.asere.kotlin.js.dsl.type.lambda.l0.JsLambda
import net.asere.kotlin.js.dsl.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.type.number.JsNumberSyntax

/**
 * Represents the JavaScript `window` object, which is the global object in client-side JavaScript.
 * It represents the window in which the document is loaded and provides a wide range of
 * properties and methods for interacting with the browser window and its contents.
 */
object Window : JsObjectRef("window") {
    /**
     * Displays an alert box with a specified message and an OK button.
     *
     * In JavaScript, this corresponds to `window.alert(message)`.
     * @param text The message to display in the alert box as a [net.asere.kotlin.js.dsl.type.string.JsString] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun alert(text: JsString): JsSyntax = JsSyntax(ChainOperation(this, "alert($text)"))

    /**
     * Displays an alert box with a specified message and an OK button.
     * This is a convenience overload for [alert] that accepts a Kotlin [String].
     *
     * @param text The message to display as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun alert(text: String): JsSyntax = alert(text.js)

    /**
     * Displays a confirmation box with a specified message, an OK button, and a Cancel button.
     *
     * In JavaScript, this corresponds to `window.confirm(message)`.
     * @param text The message to display in the confirmation box as a [JsString] object.
     * @return A [net.asere.kotlin.js.dsl.type.bool.JsBoolean] object representing the JavaScript boolean result (`true` if OK, `false` if Cancel).
     */
    fun confirm(text: JsString): JsBoolean = JsBooleanSyntax(ChainOperation(this, "confirm($text)"))

    /**
     * Displays a confirmation box with a specified message, an OK button, and a Cancel button.
     * This is a convenience overload for [confirm] that accepts a Kotlin [String].
     *
     * @param text The message to display as a Kotlin [String].
     * @return A [JsBoolean] object representing the JavaScript boolean result.
     */
    fun confirm(text: String): JsBoolean = confirm(text.js)

    /**
     * Displays a dialog box that prompts the user for input.
     *
     * In JavaScript, this corresponds to `window.prompt(message, defaultValue)`.
     * @param text The message to display in the prompt box as a [JsString] object.
     * @param defaultValue An optional [JsString] object representing the default value to display in the input field.
     * @return A [JsString] object representing the user's input, or `null` if the user cancels the dialog.
     */
    fun prompt(text: JsString, defaultValue: JsString? = null): JsString =
        JsStringSyntax(ChainOperation(this, "prompt(${text.present()}${defaultValue?.let { ", $it" } ?: ""})"))

    /**
     * Displays a dialog box that prompts the user for input.
     * This is a convenience overload for [prompt] that accepts Kotlin [String]s.
     *
     * @param text The message to display as a Kotlin [String].
     * @param defaultValue An optional Kotlin [String] representing the default value.
     * @return A [JsString] object representing the user's input, or `null` if the user cancels the dialog.
     */
    fun prompt(text: String, defaultValue: String? = null): JsString =
        prompt(text.js, defaultValue?.js)

    /**
     * Sets a timer which executes a function or specified piece of code once after the timer expires.
     *
     * In JavaScript, this corresponds to `window.setTimeout(handler, delay)`.
     * @param handler A [JsLambda] object representing the function to be executed.
     * @param delay The time, in milliseconds, the timer should wait before the specified function is executed, as a [net.asere.kotlin.js.dsl.type.number.JsNumber] object.
     * @return A [net.asere.kotlin.js.dsl.type.number.JsNumber] object representing the ID of the timer. This ID can be used with [clearTimeout].
     */
    fun setTimeout(handler: JsLambda, delay: JsNumber): JsNumber =
        JsNumberSyntax(ChainOperation(this, "setTimeout($handler, $delay)"))

    /**
     * Sets a timer which executes a function or specified piece of code once after the timer expires.
     * This is a convenience overload for [setTimeout] that accepts a Kotlin [Int] for delay.
     *
     * @param handler A [JsLambda] object representing the function to be executed.
     * @param delay The time, in milliseconds, as a Kotlin [Int].
     * @return A [JsNumber] object representing the ID of the timer.
     */
    fun setTimeout(handler: JsLambda, delay: Int): JsNumber = setTimeout(handler, delay.js)

    /**
     * Clears a timer set with [setTimeout].
     *
     * In JavaScript, this corresponds to `window.clearTimeout(timeoutId)`.
     * @param timeoutId The ID of the timer to clear as a [JsNumber] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun clearTimeout(timeoutId: JsNumber): JsSyntax = JsSyntax(ChainOperation(this, "clearTimeout($timeoutId)"))

    /**
     * Clears a timer set with [setTimeout].
     * This is a convenience overload for [clearTimeout] that accepts a Kotlin [Int].
     *
     * @param timeoutId The ID of the timer to clear as a Kotlin [Int].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun clearTimeout(timeoutId: Int): JsSyntax = clearTimeout(timeoutId.js)

    /**
     * Repeatedly calls a function or executes a code snippet, with a fixed time delay between each call.
     *
     * In JavaScript, this corresponds to `window.setInterval(handler, delay)`.
     * @param handler A [JsLambda] object representing the function to be executed.
     * @param delay The time, in milliseconds, the timer should wait between executions, as a [JsNumber] object.
     * @return A [JsNumber] object representing the ID of the interval. This ID can be used with [clearInterval].
     */
    fun setInterval(handler: JsLambda, delay: JsNumber): JsNumber =
        JsNumberSyntax(ChainOperation(this, "setInterval($handler, $delay)"))

    /**
     * Repeatedly calls a function or executes a code snippet.
     * This is a convenience overload for [setInterval] that accepts a Kotlin [Int] for delay.
     *
     * @param handler A [JsLambda] object representing the function to be executed.
     * @param delay The time, in milliseconds, as a Kotlin [Int].
     * @return A [JsNumber] object representing the ID of the interval.
     */
    fun setInterval(handler: JsLambda, delay: Int): JsNumber = setInterval(handler, delay.js)

    /**
     * Clears an interval set with [setInterval].
     *
     * In JavaScript, this corresponds to `window.clearInterval(intervalId)`.
     * @param intervalId The ID of the interval to clear as a [JsNumber] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun clearInterval(intervalId: JsNumber): JsSyntax = JsSyntax(ChainOperation(this, "clearInterval($intervalId)"))

    /**
     * Clears an interval set with [setInterval].
     * This is a convenience overload for [clearInterval] that accepts a Kotlin [Int].
     *
     * @param intervalId The ID of the interval to clear as a Kotlin [Int].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun clearInterval(intervalId: Int): JsSyntax = clearInterval(intervalId.js)

    /**
     * Returns the inner width of the browser window (viewport) in pixels as a [JsNumber] object.
     * This includes the width of the vertical scrollbar, if present.
     *
     * In JavaScript, this corresponds to `window.innerWidth`.
     */
    fun getInnerWidth(): JsNumber = JsNumberSyntax(ChainOperation(this, "innerWidth"))

    /**
     * Returns the inner height of the browser window (viewport) in pixels as a [JsNumber] object.
     * This includes the height of the horizontal scrollbar, if present.
     *
     * In JavaScript, this corresponds to `window.innerHeight`.
     */
    fun getInnerHeight(): JsNumber = JsNumberSyntax(ChainOperation(this, "innerHeight"))

    /**
     * Returns the outer width of the browser window (including toolbars/scrollbars) in pixels as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `window.outerWidth`.
     */
    fun getOuterWidth(): JsNumber = JsNumberSyntax(ChainOperation(this, "outerWidth"))

    /**
     * Returns the outer height of the browser window (including toolbars/scrollbars) in pixels as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `window.outerHeight`.
     */
    fun getOuterHeight(): JsNumber = JsNumberSyntax(ChainOperation(this, "outerHeight"))

    /**
     * Returns the number of pixels the document has been scrolled horizontally as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `window.scrollX`.
     */
    fun getScrollX(): JsNumber = JsNumberSyntax(ChainOperation(this, "scrollX"))

    /**
     * Returns the number of pixels the document has been scrolled vertically as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `window.scrollY`.
     */
    fun getScrollY(): JsNumber = JsNumberSyntax(ChainOperation(this, "scrollY"))

    /**
     * Scrolls the document to the specified coordinates.
     *
     * In JavaScript, this corresponds to `window.scrollTo(x, y)`.
     * @param x The pixel along the horizontal axis of the document to scroll to as a [JsNumber] object.
     * @param y The pixel along the vertical axis of the document to scroll to as a [JsNumber] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun scrollTo(x: JsNumber, y: JsNumber): JsSyntax = JsSyntax(ChainOperation(this, "scrollTo($x, $y)"))

    /**
     * Scrolls the document to the specified coordinates.
     * This is a convenience overload for [scrollTo] that accepts Kotlin [Int]s.
     *
     * @param x The pixel along the horizontal axis as a Kotlin [Int].
     * @param y The pixel along the vertical axis as a Kotlin [Int].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun scrollTo(x: Int, y: Int): JsSyntax = scrollTo(x.js, y.js)

    /**
     * Scrolls the document by the specified amount.
     *
     * In JavaScript, this corresponds to `window.scrollBy(x, y)`.
     * @param x The amount to scroll horizontally as a [JsNumber] object.
     * @param y The amount to scroll vertically as a [JsNumber] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun scrollBy(x: JsNumber, y: JsNumber): JsSyntax = JsSyntax(ChainOperation(this, "scrollBy($x, $y)"))

    /**
     * Scrolls the document by the specified amount.
     * This is a convenience overload for [scrollBy] that accepts Kotlin [Int]s.
     *
     * @param x The amount to scroll horizontally as a Kotlin [Int].
     * @param y The amount to scroll vertically as a Kotlin [Int].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun scrollBy(x: Int, y: Int): JsSyntax = scrollBy(x.js, y.js)

    /**
     * Returns the name of the window as a [JsString] object.
     *
     * In JavaScript, this corresponds to `window.name`.
     */
    fun getName(): JsString = JsStringSyntax(ChainOperation(this, "name"))

    /**
     * Sets the name of the window.
     *
     * In JavaScript, this corresponds to `window.name = name`.
     * @param name The new name as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setName(name: JsString): JsSyntax = JsSyntax("${ChainOperation(this, "name")} = $name")

    /**
     * Sets the name of the window.
     * This is a convenience overload for [setName] that accepts a Kotlin [String].
     *
     * @param name The new name as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setName(name: String): JsSyntax = setName(name.js)

    /**
     * Returns a boolean indicating whether the window has been closed as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `window.closed`.
     */
    fun getClosed(): JsBoolean = JsBooleanSyntax(ChainOperation(this, "closed"))

    /**
     * Closes the current window. This method can only be called on windows that were opened by script.
     *
     * In JavaScript, this corresponds to `window.close()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun close(): JsSyntax = JsSyntax(ChainOperation(this, "close()"))

    /**
     * Opens a new browser window or tab.
     *
     * In JavaScript, this corresponds to `window.open(url, windowName, features)`.
     * @param url An optional [JsString] object specifying the URL to load in the new window.
     * @param windowName An optional [JsString] object specifying the name of the new window.
     * @param features An optional [JsString] object specifying window features (e.g., "width=200,height=100").
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun open(url: JsString? = null, windowName: JsString? = null, features: JsString? = null): JsSyntax =
        JsSyntax(
            ChainOperation(
                this,
                "open(${url ?: "''"}${windowName?.let { ", $it" } ?: ""}${features?.let { ", $it" } ?: ""})"))

    /**
     * Opens a new browser window or tab.
     * This is a convenience overload for [open] that accepts Kotlin [String]s.
     *
     * @param url An optional Kotlin [String] specifying the URL.
     * @param windowName An optional Kotlin [String] specifying the name.
     * @param features An optional Kotlin [String] specifying window features.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun open(url: String? = null, windowName: String? = null, features: String? = null): JsSyntax =
        open(url?.js, windowName?.js, features?.js)

    /**
     * Opens the Print Dialog to print the current document.
     *
     * In JavaScript, this corresponds to `window.print()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun print(): JsSyntax = JsSyntax(ChainOperation(this, "print()"))

    /**
     * Returns the [JsLocation] object, which contains information about the current URL.
     */
    val location: JsLocation
        get() = JsLocationSyntax(ChainOperation(this, "location"))

    /**
     * Returns the [net.asere.kotlin.js.dsl.dom.type.obj.JsDomObject] representing the `document` object, which is the root of the DOM tree.
     */
    val document: JsDocument
        get() = JsDocumentSyntax(ChainOperation(this, "document"))

    /**
     * Returns the [JsHistory] object, which provides access to the browser's session history.
     */
    val history: JsHistory
        get() = JsHistorySyntax(ChainOperation(this, "history"))

    /**
     * Returns the [JsNavigator] object, which contains information about the web browser.
     */
    val navigator: JsNavigator
        get() = JsNavigatorSyntax(ChainOperation(this, "navigator"))

    /**
     * Returns the [JsScreen] object, which contains information about the user's screen.
     */
    val screen: JsScreen
        get() = JsScreenSyntax(ChainOperation(this, "screen"))

    /**
     * Attaches an event listener to the window. When the specified event occurs,
     * the provided handler function will be executed.
     *
     * In JavaScript, this corresponds to `window.addEventListener(event, handler)`.
     * @param event The name of the event to listen for (e.g., "load", "resize") as a [JsString] object.
     * @param handler A [JsLambda1] representing the JavaScript function to execute when the event occurs.
     * The function typically receives a [JsDomEvent] object as its first argument.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun addEventListener(event: JsString, handler: JsLambda1<JsDomEvent>): JsSyntax =
        JsSyntax(ChainOperation(this, "addEventListener($event, $handler)"))

    /**
     * Attaches an event listener to the window.
     * This is a convenience overload for [addEventListener] that accepts a Kotlin [String] for the event name.
     *
     * @param event The name of the event to listen for as a Kotlin [String].
     * @param handler A [JsLambda1] representing the JavaScript function to execute.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun addEventListener(event: String, handler: JsLambda1<JsDomEvent>): JsSyntax = addEventListener(event.js, handler)

    /**
     * Removes an event listener from the window.
     * The `handler` function must be the *exact same function instance* that was originally added.
     *
     * In JavaScript, this corresponds to `window.removeEventListener(event, handler)`.
     * @param event The name of the event as a [JsString] object.
     * @param handler A [JsLambda1] representing the JavaScript function that was previously added.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun removeEventListener(event: JsString, handler: JsLambda1<JsDomEvent>): JsSyntax =
        JsSyntax(ChainOperation(this, "removeEventListener($event, $handler)"))

    /**
     * Removes an event listener from the window.
     * This is a convenience overload for [removeEventListener] that accepts a Kotlin [String] for the event name.
     *
     * @param event The name of the event as a Kotlin [String].
     * @param handler A [JsLambda1] representing the JavaScript function that was previously added.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun removeEventListener(event: String, handler: JsLambda1<JsDomEvent>): JsSyntax =
        removeEventListener(event.js, handler)
}