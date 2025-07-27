package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.JsString
import net.asere.kotlin.js.dsl.types.type.js

/**
* Represents the JavaScript `History` object, which provides access to the browser's session history.
* It allows manipulation of the browser session history, as well as navigation back and forth
* through the history.
*
* This object is typically accessed via `window.history`.
*/
interface JsHistory : JsObject {
    /**
     * Returns the number of entries in the session history, including the currently loaded page,
     * as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `window.history.length`.
     */
    val length: JsNumber get() = JsNumberSyntax(ChainOperation(this, "length"))

    /**
     * Navigates back one step in the browser's history.
     * This is equivalent to clicking the browser's "back" button.
     *
     * In JavaScript, this corresponds to `window.history.back()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun back(): JsSyntax = JsSyntax(ChainOperation(this, "back()"))

    /**
     * Navigates forward one step in the browser's history.
     * This is equivalent to clicking the browser's "forward" button.
     *
     * In JavaScript, this corresponds to `window.history.forward()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun forward(): JsSyntax = JsSyntax(ChainOperation(this, "forward()"))

    /**
     * Navigates to a specific entry in the browser's history relative to the current page.
     * A positive `delta` moves forward, a negative `delta` moves backward.
     *
     * In JavaScript, this corresponds to `window.history.go(delta)`.
     * @param delta The number of steps to go forward or backward as a [JsNumber] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun go(delta: JsNumber): JsSyntax = JsSyntax(ChainOperation(this, "go($delta)"))

    /**
     * Navigates to a specific entry in the browser's history relative to the current page.
     * This is a convenience overload for [go] that accepts a Kotlin [Int].
     *
     * @param delta The number of steps to go forward or backward as a Kotlin [Int].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun go(delta: Int): JsSyntax = go(delta.js)

    /**
     * Pushes a new state onto the browser's session history stack.
     * This changes the URL in the address bar without reloading the page.
     *
     * In JavaScript, this corresponds to `window.history.pushState(state, title, url)`.
     * @param state A [JsSyntax] object representing the state object (can be any serializable JavaScript object).
     * @param title The title for the new history entry as a [JsString] object. This is largely ignored by browsers.
     * @param url The new URL for the history entry as an optional [JsString] object. If `null`, the current URL is used.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun pushState(state: JsSyntax, title: JsString, url: JsString? = null): JsSyntax =
        JsSyntax(ChainOperation(this, "pushState($state, $title${url?.let { ", $it" } ?: ""})"))

    /**
     * Pushes a new state onto the browser's session history stack.
     * This is a convenience overload for [pushState] that accepts Kotlin [String] for title and url.
     *
     * @param state A [JsSyntax] object representing the state object.
     * @param title The title for the new history entry as a Kotlin [String].
     * @param url The new URL for the history entry as an optional Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun pushState(state: JsSyntax, title: String, url: String? = null): JsSyntax = pushState(state, title.js, url?.js)

    /**
     * Modifies the current entry in the browser's session history stack.
     * This changes the URL in the address bar without reloading the page, but does not add a new history entry.
     *
     * In JavaScript, this corresponds to `window.history.replaceState(state, title, url)`.
     * @param state A [JsSyntax] object representing the state object (can be any serializable JavaScript object).
     * @param title The title for the current history entry as a [JsString] object.
     * @param url The new URL for the history entry as an optional [JsString] object. If `null`, the current URL is used.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun replaceState(state: JsSyntax, title: JsString, url: JsString? = null): JsSyntax =
        JsSyntax(ChainOperation(this, "replaceState($state, $title${url?.let { ", $it" } ?: ""})"))

    /**
     * Modifies the current entry in the browser's session history stack.
     * This is a convenience overload for [replaceState] that accepts Kotlin [String] for title and url.
     *
     * @param state A [JsSyntax] object representing the state object.
     * @param title The title for the current history entry as a Kotlin [String].
     * @param url The new URL for the history entry as an optional Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun replaceState(state: JsSyntax, title: String, url: String? = null): JsSyntax = replaceState(state, title.js, url?.js)

    companion object
}