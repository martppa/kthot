package net.asere.kthot.js.dsl.dom.type.html.anchor

import net.asere.kthot.js.dsl.dom.type.html.element.JsHtmlElement
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.JsStringRef
import net.asere.kthot.js.dsl.type.string.ref

/**
 * Represents the JavaScript DOM HTMLAnchorElement interface, corresponding to the HTML <a> tag.
 * It extends JsHtmlElement and provides properties for manipulating the link's URL components.
 */
interface JsAnchorElement : JsHtmlElement {

    /**
     * Reflects the HTML href attribute, containing the full URL of the linked resource.
     * In JavaScript, this corresponds to `anchor.href`.
     */
    val href: JsStringRef get() = JsString.ref(ChainOperation(this, "href"))

    /**
     * Reflects the HTML target attribute, indicating where to display the linked resource (e.g., "_blank", "_self").
     * In JavaScript, this corresponds to `anchor.target`.
     */
    val target: JsStringRef get() = JsString.ref(ChainOperation(this, "target"))

    /**
     * Reflects the HTML rel attribute, specifying the relationship between the linked resource and the current document.
     * In JavaScript, this corresponds to `anchor.rel`.
     */
    val rel: JsStringRef get() = JsString.ref(ChainOperation(this, "rel"))

    /**
     * Reflects the HTML hreflang attribute, specifying the language of the linked resource.
     * In JavaScript, this corresponds to `anchor.hreflang`.
     */
    val hreflang: JsStringRef get() = JsString.ref(ChainOperation(this, "hreflang"))

    /**
     * Reflects the HTML type attribute, indicating the MIME type of the linked resource.
     * In JavaScript, this corresponds to `anchor.type`.
     */
    val type: JsStringRef get() = JsString.ref(ChainOperation(this, "type"))

    /**
     * Reflects the HTML download attribute, suggesting a file name for the resource to be downloaded.
     * In JavaScript, this corresponds to `anchor.download`.
     */
    val download: JsStringRef get() = JsString.ref(ChainOperation(this, "download"))

    // --- URL Component Properties ---

    /**
     * The URL's protocol scheme (e.g., "http:", "https:", "ftp:").
     * In JavaScript, this corresponds to `anchor.protocol`.
     */
    val protocol: JsStringRef get() = JsString.ref(ChainOperation(this, "protocol"))

    /**
     * The URL's host (hostname plus port number, if port is not default).
     * In JavaScript, this corresponds to `anchor.host`.
     */
    val host: JsStringRef get() = JsString.ref(ChainOperation(this, "host"))

    /**
     * The URL's hostname (domain name).
     * In JavaScript, this corresponds to `anchor.hostname`.
     */
    val hostname: JsStringRef get() = JsString.ref(ChainOperation(this, "hostname"))

    /**
     * The URL's path, starting with a slash (`/`).
     * In JavaScript, this corresponds to `anchor.pathname`.
     */
    val pathname: JsStringRef get() = JsString.ref(ChainOperation(this, "pathname"))

    /**
     * The URL's query string, starting with a question mark (`?`).
     * In JavaScript, this corresponds to `anchor.search`.
     */
    val search: JsStringRef get() = JsString.ref(ChainOperation(this, "search"))

    /**
     * The URL's fragment identifier, starting with a hash symbol (`#`).
     * In JavaScript, this corresponds to `anchor.hash`.
     */
    val hash: JsStringRef get() = JsString.ref(ChainOperation(this, "hash"))

    companion object
}