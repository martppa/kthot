package net.asere.kotlin.js.dsl.dom.type.document

import net.asere.kotlin.js.dsl.dom.type.array.JsDomArray
import net.asere.kotlin.js.dsl.dom.type.`object`.JsDomObject
import net.asere.kotlin.js.dsl.dom.type.array.JsDomArraySyntax
import net.asere.kotlin.js.dsl.dom.type.`object`.JsDomObjectSyntax
import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.bool.js

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
    fun getElementById(id: JsString): JsDomObject =
        JsDomObjectSyntax(ChainOperation(this, InvocationOperation("getElementById", id)))

    fun getElementById(id: String): JsDomObject = getElementById(id.js)

    /**
     * Returns a live `HTMLCollection` of all elements in the document with the specified class name.
     *
     * In JavaScript, this corresponds to `document.getElementsByClassName(className)`.
     * @param className The class name to search for as a [JsString] object.
     * @return A [JsDomArray] containing all matching elements.
     */
    fun getElementsByClassName(className: JsString): JsDomArray =
        JsDomArraySyntax(ChainOperation(this, InvocationOperation("getElementsByClassName", className)))

    fun getElementsByClassName(className: String): JsDomArray = getElementsByClassName(className.js)

    /**
     * Returns a live `HTMLCollection` of all elements in the document with the specified tag name.
     *
     * In JavaScript, this corresponds to `document.getElementsByTagName(tagName)`.
     * @param tagName The tag name to search for (e.g., "div", "p") as a [JsString] object. Use "*" for all elements.
     * @return A [JsDomArray] containing all matching elements.
     */
    fun getElementsByTagName(tagName: JsString): JsDomArray =
        JsDomArraySyntax(ChainOperation(this, InvocationOperation("getElementsByTagName", tagName)))

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
        JsDomArraySyntax(ChainOperation(this, InvocationOperation("getElementsByName", name)))

    fun getElementsByName(name: String): JsDomArray = getElementsByName(name.js)

    /**
     * Creates a new HTML element with the specified tag name.
     *
     * In JavaScript, this corresponds to `document.createElement(tagName)`.
     * @param tagName The tag name of the element to create (e.g., "div", "span") as a [JsString] object.
     * @return A new [JsDomObject] representing the created element.
     */
    fun createElement(tagName: JsString): JsDomObject =
        JsDomObjectSyntax(ChainOperation(this, InvocationOperation("createElement", tagName)))

    fun createElement(tagName: String): JsDomObject = createElement(tagName.js)

    /**
     * Creates a new text node with the specified text.
     *
     * In JavaScript, this corresponds to `document.createTextNode(text)`.
     * @param text The text content for the new text node as a [JsString] object.
     * @return A new [JsDomObject] representing the created text node.
     */
    fun createTextNode(text: JsString): JsDomObject =
        JsDomObjectSyntax(ChainOperation(this, InvocationOperation("createTextNode", text)))

    fun createTextNode(text: String): JsDomObject = createTextNode(text.js)

    /**
     * Creates a new comment node with the specified text.
     *
     * In JavaScript, this corresponds to `document.createComment(text)`.
     * @param text The text content for the new comment node as a [JsString] object.
     * @return A new [JsDomObject] representing the created comment node.
     */
    fun createComment(text: JsString): JsDomObject =
        JsDomObjectSyntax(ChainOperation(this, InvocationOperation("createComment", text)))

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
        JsDomObjectSyntax(ChainOperation(this, InvocationOperation("createDocumentFragment")))

    companion object
}