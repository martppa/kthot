package net.asere.kotlin.js.dsl.dom.type.navigator

import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.obj.JsObjectSyntax
import net.asere.kotlin.js.dsl.type.string.JsStringSyntax
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.JsBooleanSyntax
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.string.JsString

/**
 * Represents the JavaScript `Navigator` object, which contains information about the web browser
 * and the user's operating system.
 *
 * This object is typically accessed via `window.navigator`.
 */
interface JsNavigator : JsObject {
    /**
     * Returns the user-agent string for the current browser as a [JsString] object.
     * This string typically contains information about the browser, operating system, and device.
     *
     * In JavaScript, this corresponds to `navigator.userAgent`.
     */
    val userAgent: JsString get() = JsStringSyntax(ChainOperation(this, "userAgent"))

    /**
     * Returns the platform on which the browser is running (e.g., "Win32", "MacIntel") as a [JsString] object.
     * This property is considered deprecated; use `userAgent` or feature detection instead.
     *
     * In JavaScript, this corresponds to `navigator.platform`.
     */
    val platform: JsString get() = JsStringSyntax(ChainOperation(this, "platform"))

    /**
     * Returns the preferred language of the user's browser as a [JsString] object (e.g., "en-US", "es").
     *
     * In JavaScript, this corresponds to `navigator.language`.
     */
    val language: JsString get() = JsStringSyntax(ChainOperation(this, "language"))

    /**
     * Returns a boolean indicating whether the browser is online or offline as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `navigator.onLine`.
     */
    val onLine: JsBoolean get() = JsBooleanSyntax(ChainOperation(this, "onLine"))

    /**
     * Returns a boolean indicating whether cookies are enabled in the browser as a [JsBoolean] object.
     *
     * In JavaScript, this corresponds to `navigator.cookieEnabled`.
     */
    val cookieEnabled: JsBoolean get() = JsBooleanSyntax(ChainOperation(this, "cookieEnabled"))

    /**
     * Returns a boolean indicating whether Java is enabled in the browser as a [JsBoolean] object.
     * This property is deprecated.
     *
     * In JavaScript, this corresponds to `navigator.javaEnabled()`.
     */
    fun javaEnabled(): JsBoolean = JsBooleanSyntax(ChainOperation(this, InvocationOperation("javaEnabled")))

    /**
     * Returns a [JsObject] representing the Geolocation API, allowing access to the device's location.
     *
     * In JavaScript, this corresponds to `navigator.geolocation`.
     */
    val geolocation: JsObject get() = JsObjectSyntax(ChainOperation(this, "geolocation"))

    /**
     * Returns a [JsObject] representing the MediaDevices API, allowing access to media input/output devices.
     *
     * In JavaScript, this corresponds to `navigator.mediaDevices`.
     */
    val mediaDevices: JsObject get() = JsObjectSyntax(ChainOperation(this, "mediaDevices"))

    /**
     * Returns a [JsString] representing the name of the browser's vendor.
     *
     * In JavaScript, this corresponds to `navigator.vendor`.
     */
    val vendor: JsString get() = JsStringSyntax(ChainOperation(this, "vendor"))

    /**
     * Returns a [JsString] representing the version of the browser.
     *
     * In JavaScript, this corresponds to `navigator.appVersion`.
     */
    val appVersion: JsString get() = JsStringSyntax(ChainOperation(this, "appVersion"))

    companion object
}