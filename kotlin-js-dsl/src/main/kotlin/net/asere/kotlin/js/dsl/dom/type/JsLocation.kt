package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.value.JsStringSyntax
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.JsString
import net.asere.kotlin.js.dsl.types.type.js

/**
 * Represents the JavaScript `Location` object, which contains information about the current URL
 * and provides methods for navigating the browser window.
 *
 * This object is typically accessed via `window.location`.
 */
interface JsLocation : JsObject {
    /**
     * Returns the entire URL as a [JsString] object.
     *
     * In JavaScript, this corresponds to `window.location.href`.
     */
    fun getHref(): JsString = JsStringSyntax(ChainOperation(this, "href"))

    /**
     * Sets the entire URL, causing the browser to navigate to the new URL.
     *
     * In JavaScript, this corresponds to `window.location.href = url`.
     * @param url The new URL as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setHref(url: JsString): JsSyntax = JsSyntax("${ChainOperation(this, "href")} = $url")

    /**
     * Sets the entire URL, causing the browser to navigate to the new URL.
     *
     * This is a convenience overload for [setHref] that accepts a Kotlin [String].
     *
     * @param url The new URL as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript assignment.
     */
    fun setHref(url: String): JsSyntax = setHref(url.js)

    /**
     * Returns the hostname (e.g., "www.example.com") of the current URL as a [JsString] object.
     *
     * In JavaScript, this corresponds to `window.location.hostname`.
     */
    val hostname: JsString get() = JsStringSyntax(ChainOperation(this, "hostname"))

    /**
     * Returns the pathname (e.g., "/path/to/page.html") of the current URL as a [JsString] object.
     * Includes the leading '/'.
     *
     * In JavaScript, this corresponds to `window.location.pathname`.
     */
    val pathname: JsString get() = JsStringSyntax(ChainOperation(this, "pathname"))

    /**
     * Returns the query string (e.g., "?param1=value1&param2=value2") of the current URL as a [JsString] object.
     * Includes the leading '?'.
     *
     * In JavaScript, this corresponds to `window.location.search`.
     */
    val search: JsString get() = JsStringSyntax(ChainOperation(this, "search"))

    /**
     * Returns the fragment identifier (e.g., "#section1") of the current URL as a [JsString] object.
     * Includes the leading '#'.
     *
     * In JavaScript, this corresponds to `window.location.hash`.
     */
    val hash: JsString get() = JsStringSyntax(ChainOperation(this, "hash"))

    /**
     * Returns the port number (e.g., "8080") of the current URL as a [JsString] object.
     * Returns an empty string if no port is specified.
     *
     * In JavaScript, this corresponds to `window.location.port`.
     */
    val port: JsString get() = JsStringSyntax(ChainOperation(this, "port"))

    /**
     * Returns the protocol (e.g., "http:", "https:") of the current URL as a [JsString] object.
     * Includes the trailing ':'.
     *
     * In JavaScript, this corresponds to `window.location.protocol`.
     */
    val protocol: JsString get() = JsStringSyntax(ChainOperation(this, "protocol"))

    /**
     * Loads a new document at the specified URL.
     * This method adds the new URL to the browser's history.
     *
     * In JavaScript, this corresponds to `window.location.assign(url)`.
     * @param url The URL to navigate to as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun assign(url: JsString): JsSyntax = JsSyntax(ChainOperation(this, "assign($url)"))

    /**
     * Loads a new document at the specified URL.
     * This is a convenience overload for [assign] that accepts a Kotlin [String].
     *
     * @param url The URL to navigate to as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun assign(url: String): JsSyntax = assign(url.js)

    /**
     * Reloads the current document.
     *
     * In JavaScript, this corresponds to `window.location.reload()`.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun reload(): JsSyntax = JsSyntax(ChainOperation(this, "reload()"))

    /**
     * Replaces the current document in the browser's history with a new one.
     * This means the current page will not be accessible via the "back" button.
     *
     * In JavaScript, this corresponds to `window.location.replace(url)`.
     * @param url The URL to replace the current document with as a [JsString] object.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun replace(url: JsString): JsSyntax = JsSyntax(ChainOperation(this, "replace($url)"))

    /**
     * Replaces the current document in the browser's history with a new one.
     * This is a convenience overload for [replace] that accepts a Kotlin [String].
     *
     * @param url The URL to replace the current document with as a Kotlin [String].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun replace(url: String): JsSyntax = replace(url.js)

    companion object
}