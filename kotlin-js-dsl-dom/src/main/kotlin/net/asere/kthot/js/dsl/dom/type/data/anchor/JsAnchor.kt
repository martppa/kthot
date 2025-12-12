package net.asere.kthot.js.dsl.dom.type.data.anchor

import net.asere.kthot.js.dsl.dom.type.data.obj.JsDomObject
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.JsStringRef
import net.asere.kthot.js.dsl.type.string.ref
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents the JavaScript DOM object for an HTML <a> (Anchor) element.
 * This object is an instance of the HTMLAnchorElement interface.
 *
 * It provides properties and methods for accessing and manipulating the link's URL components
 * and attributes.
 */
interface JsAnchor : JsDomObject {

    /**
     * URL of the linked resource.
     *
     * In JavaScript, this corresponds to `anchor.href`.
     */
    val href: JsStringRef get() = JsString.ref(ChainOperation(this, "href"))

    /**
     * The protocol scheme of the URL (e.g., "http:", "https:").
     *
     * In JavaScript, this corresponds to `anchor.protocol`.
     */
    val protocol: JsStringRef get() = JsString.ref(ChainOperation(this, "protocol"))

    /**
     * The hostname and port of the URL (e.g., "www.example.com:8080").
     *
     * In JavaScript, this corresponds to `anchor.host`.
     */
    val host: JsStringRef get() = JsString.ref(ChainOperation(this, "host"))

    /**
     * The domain name of the URL (e.g., "www.example.com").
     *
     * In JavaScript, this corresponds to `anchor.hostname`.
     */
    val hostname: JsStringRef get() = JsString.ref(ChainOperation(this, "hostname"))

    /**
     * The port number of the URL (e.g., "8080").
     *
     * In JavaScript, this corresponds to `anchor.port`.
     */
    val port: JsStringRef get() = JsString.ref(ChainOperation(this, "port"))

    /**
     * The path component of the URL (e.g., "/path/to/page.html").
     *
     * In JavaScript, this corresponds to `anchor.pathname`.
     */
    val pathname: JsStringRef get() = JsString.ref(ChainOperation(this, "pathname"))

    /**
     * The query string of the URL (e.g., "?query=value").
     *
     * In JavaScript, this corresponds to `anchor.search`.
     */
    val search: JsStringRef get() = JsString.ref(ChainOperation(this, "search"))

    /**
     * The fragment identifier of the URL (e.g., "#section").
     *
     * In JavaScript, this corresponds to `anchor.hash`.
     */
    val hash: JsStringRef get() = JsString.ref(ChainOperation(this, "hash"))

    /**
     * Read-only. Returns the origin of the URL (scheme, domain, and port).
     *
     * In JavaScript, this corresponds to `anchor.origin`.
     */
    val origin: JsString get() = JsString.syntax(ChainOperation(this, "origin"))

    /**
     * The target frame or window for the link.
     *
     * In JavaScript, this corresponds to `anchor.target`.
     */
    val target: JsStringRef get() = JsString.ref(ChainOperation(this, "target"))

    /**
     * The suggested filename for the resource if it is to be downloaded.
     *
     * In JavaScript, this corresponds to `anchor.download`.
     */
    val download: JsStringRef get() = JsString.ref(ChainOperation(this, "download"))

    /**
     * The relationship between the linked document and the current document.
     *
     * In JavaScript, this corresponds to `anchor.rel`.
     */
    val rel: JsStringRef get() = JsString.ref(ChainOperation(this, "rel"))

    /**
     * The language of the linked resource.
     *
     * In JavaScript, this corresponds to `anchor.hreflang`.
     */
    val hreflang: JsStringRef get() = JsString.ref(ChainOperation(this, "hreflang"))

    /**
     * The MIME type of the linked resource.
     *
     * In JavaScript, this corresponds to `anchor.type`.
     */
    val type: JsStringRef get() = JsString.ref(ChainOperation(this, "type"))

    /**
     * Returns the full URL as a string. This is functionally equivalent to accessing the [href] property.
     *
     * In JavaScript, this corresponds to `anchor.toString()`.
     */
    fun jsToString(): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("toString")))

    companion object
}