package net.asere.kthot.js.dsl.dom.type.content.document

import net.asere.kthot.js.dsl.dom.type.data.array.JsDomArray
import net.asere.kthot.js.dsl.dom.type.data.array.syntax
import net.asere.kthot.js.dsl.dom.type.data.obj.JsDomObject
import net.asere.kthot.js.dsl.dom.type.data.obj.syntax
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.js
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.js
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents the JavaScript `document` object, which serves as the entry point into the web page's
 * content (the DOM tree). It provides properties and methods to access and manipulate the HTML content.
 *
 * This object is typically accessed via `window.document` or simply `document` in global scope.
 */
interface JsDocument : JsDomObject {

    /**
     * Returns a reference to the element by its ID.
     *
     * In JavaScript, this corresponds to `document.getElementById(id)`.
     * @param id The ID of the element to find as a [JsString] object.
     * @return A [JsDomObject] representing the element, or `null` if no element with the specified ID exists.
     */
    fun getDomElementById(id: JsString): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("getElementById", id)))

    fun getDomElementById(id: String): JsDomObject = getDomElementById(id.js)

    /**
     * Returns a live `HTMLCollection` of all elements in the document with the specified class name.
     *
     * In JavaScript, this corresponds to `document.getElementsByClassName(className)`.
     * @param className The class name to search for as a [JsString] object.
     * @return A [JsDomArray] containing all matching elements.
     */
    fun getElementsByClassName(className: JsString): JsDomArray =
        JsDomArray.syntax(ChainOperation(this, InvocationOperation("getElementsByClassName", className)))

    fun getElementsByClassName(className: String): JsDomArray = getElementsByClassName(className.js)

    /**
     * Returns a live `HTMLCollection` of all elements in the document with the specified tag name.
     *
     * In JavaScript, this corresponds to `document.getElementsByTagName(tagName)`.
     * @param tagName The tag name to search for (e.g., "div", "p") as a [JsString] object. Use "*" for all elements.
     * @return A [JsDomArray] containing all matching elements.
     */
    fun getElementsByTagName(tagName: JsString): JsDomArray =
        JsDomArray.syntax(ChainOperation(this, InvocationOperation("getElementsByTagName", tagName)))

    fun getElementsByTagName(tagName: String): JsDomArray = getElementsByTagName(tagName.js)

    /**
     * Returns a live `NodeList` of all elements in the document with the specified `name` attribute.
     * This is commonly used for form elements.
     *
     * In JavaScript, this corresponds to `document.getElementsByName(name)`.
     * @param name The value of the `name` attribute to search for as a [JsString] object.
     * @return A [JsDomArray] containing all matching elements.
     */
    fun getElementsByName(name: JsString): JsDomArray =
        JsDomArray.syntax(ChainOperation(this, InvocationOperation("getElementsByName", name)))

    fun getElementsByName(name: String): JsDomArray = getElementsByName(name.js)

    /**
     * Creates a new HTML element with the specified tag name.
     *
     * In JavaScript, this corresponds to `document.createElement(tagName)`.
     * @param tagName The tag name of the element to create (e.g., "div", "span") as a [JsString] object.
     * @return A new [JsDomObject] representing the created element.
     */
    fun createElement(tagName: JsString): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("createElement", tagName)))

    fun createElement(tagName: String): JsDomObject = createElement(tagName.js)

    /**
     * Creates a new text node with the specified text.
     *
     * In JavaScript, this corresponds to `document.createTextNode(text)`.
     * @param text The text content for the new text node as a [JsString] object.
     * @return A new [JsDomObject] representing the created text node.
     */
    fun createTextNode(text: JsString): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("createTextNode", text)))

    fun createTextNode(text: String): JsDomObject = createTextNode(text.js)

    /**
     * Creates a new comment node with the specified text.
     *
     * In JavaScript, this corresponds to `document.createComment(text)`.
     * @param text The text content for the new comment node as a [JsString] object.
     * @return A new [JsDomObject] representing the created comment node.
     */
    fun createComment(text: JsString): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("createComment", text)))

    fun createComment(text: String): JsDomObject = createComment(text.js)

    /**
     * Creates a new `DocumentFragment`. A `DocumentFragment` is a lightweight version of `Document`
     * that can store a part of a document structure. It is often used to build up a DOM subtree
     * and then append it to the main document in a single operation, improving performance.
     *
     * In JavaScript, this corresponds to `document.createDocumentFragment()`.
     * @return A new [JsDomObject] representing the created `DocumentFragment`.
     */
    fun createDocumentFragment(): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("createDocumentFragment")))

    /**
     * Gets the title of the current document.
     * Corresponds to `document.title` in JavaScript.
     */
    val title: JsString
        get() = JsString.syntax(ChainOperation(this, "title"))

    /**
     * Gets the URL of the current document.
     * Corresponds to `document.URL` in JavaScript.
     */
    val URL: JsString
        get() = JsString.syntax(ChainOperation(this, "URL"))

    /**
     * Gets the domain of the current document.
     * Corresponds to `document.domain` in JavaScript.
     */
    val domain: JsString
        get() = JsString.syntax(ChainOperation(this, "domain"))

    /**
     * Returns the `<html>` element.
     * Corresponds to `document.documentElement` in JavaScript.
     */
    val documentElement: JsDomObject
        get() = JsDomObject.syntax(ChainOperation(this, "documentElement"))

    /**
     * Returns the `<body>` element.
     * Corresponds to `document.body` in JavaScript.
     */
    val body: JsDomObject
        get() = JsDomObject.syntax(ChainOperation(this, "body"))

    /**
     * Returns the `<head>` element.
     * Corresponds to `document.head` in JavaScript.
     */
    val head: JsDomObject
        get() = JsDomObject.syntax(ChainOperation(this, "head"))

    /**
     * Returns a live `HTMLCollection` of all forms in the document.
     * Corresponds to `document.forms` in JavaScript.
     */
    val forms: JsDomArray
        get() = JsDomArray.syntax(ChainOperation(this, "forms"))

    /**
     * Returns a live `HTMLCollection` of all images in the document.
     * Corresponds to `document.images` in JavaScript.
     */
    val images: JsDomArray
        get() = JsDomArray.syntax(ChainOperation(this, "images"))

    /**
     * Returns a live `HTMLCollection` of all links in the document.
     * Corresponds to `document.links` in JavaScript.
     */
    val links: JsDomArray
        get() = JsDomArray.syntax(ChainOperation(this, "links"))

    /**
     * Creates a new attribute node with the specified name.
     * Corresponds to `document.createAttribute(attributeName)`.
     */
    fun createAttribute(attributeName: JsString): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("createAttribute", attributeName)))

    fun createAttribute(attributeName: String): JsDomObject = createAttribute(attributeName.js)

    /**
     * Creates a new event object of the specified type.
     * Corresponds to `document.createEvent(type)`.
     */
    fun createEvent(type: JsString): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("createEvent", type)))

    fun createEvent(type: String): JsDomObject = createEvent(type.js)

    /**
     * Creates a new `Range` object.
     * Corresponds to `document.createRange()`.
     */
    fun createRange(): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("createRange")))

    /**
     * Clones a node from an external document.
     * Corresponds to `document.importNode(node, deep)`.
     */
    fun importNode(node: JsDomObject, deep: JsBoolean): JsDomObject =
        JsDomObject.syntax(ChainOperation(this, InvocationOperation("importNode", node, deep)))

    fun importNode(node: JsDomObject, deep: Boolean): JsDomObject = importNode(node, deep.js)

    /**
     * Writes a string of text to a document stream opened by `document.open()`.
     * Corresponds to `document.write(text)`.
     */
    fun write(text: JsString) = ChainOperation(this, InvocationOperation("write", text))

    fun write(text: String) = write(text.js)

    /**
     * Writes a string of text followed by a newline to a document stream.
     * Corresponds to `document.writeln(text)`.
     */
    fun writeln(text: JsString) = ChainOperation(this, InvocationOperation("writeln", text))

    fun writeln(text: String) = writeln(text.js)

    companion object
}

/**
 * Returns a reference to the element by its ID.
 *
 * In JavaScript, this corresponds to `document.getElementById(id)`.
 * @param id The ID of the element to find as a [JsString] object.
 * @return A [T] representing the element, or `null` if no element with the specified ID exists.
 */
inline fun <reified T : JsDomObject> JsDocument.getElementById(id: JsString): T = provide(ChainOperation(this, InvocationOperation("getElementById", id)))

inline fun <reified T : JsDomObject> JsDocument.getElementById(id: String): T = getElementById(id.js)