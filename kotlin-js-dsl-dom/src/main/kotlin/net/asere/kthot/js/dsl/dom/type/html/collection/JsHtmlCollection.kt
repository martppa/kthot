package net.asere.kthot.js.dsl.dom.type.html.collection

import net.asere.kthot.js.dsl.dom.type.html.element.JsHtmlElement
import net.asere.kthot.js.dsl.dom.type.html.element.syntax
import net.asere.kthot.js.dsl.syntax.operational.access.operation.AccessOperation
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.js
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.js

/**
 * Represents the JavaScript DOM HTMLCollection interface.
 * This is a live, array-like collection of document elements (Element nodes only).
 * It provides basic access by index and name.
 */
interface JsHtmlCollection : JsObject {

    /**
     * Returns the number of elements in the collection.
     * In JavaScript, this corresponds to `collection.length`.
     */
    val length: JsNumber get() = JsNumber.syntax(ChainOperation(this, "length"))

    /**
     * Allows accessing an element in the collection using the Kotlin array-access operator `[]`.
     * In JavaScript, this corresponds to `collection[index]`.
     * @param index The zero-based index of the element to retrieve as a [JsNumber] object.
     * @return A [JsHtmlElement] representing the HTML element at the specified index.
     */
    operator fun get(index: JsNumber): JsHtmlElement = JsHtmlElement.syntax(AccessOperation(this, index))

    /**
     * Allows accessing an element in the collection using the Kotlin array-access operator `[]`.
     * This is a convenience overload for [get] that accepts a Kotlin [Int].
     * @param index The zero-based index of the element to retrieve as a Kotlin [Int].
     * @return A [JsHtmlElement] representing the HTML element at the specified index.
     */
    operator fun get(index: Int): JsHtmlElement = get(index.js)

    /**
     * Returns an element in the collection using the `item()` method.
     * In JavaScript, this corresponds to `collection.item(index)`.
     * @param index The zero-based index of the element to retrieve as a [JsNumber] object.
     * @return A [JsHtmlElement] representing the HTML element at the specified index.
     */
    fun item(index: JsNumber): JsHtmlElement =
        JsHtmlElement.syntax(ChainOperation(this, InvocationOperation("item", index)))

    /**
     * Returns the first element in the collection that has the specified `id` or `name` attribute.
     * This method is unique to [HTMLCollection].
     * In JavaScript, this corresponds to `collection.namedItem(name)`.
     * @param name The `id` or `name` of the element to retrieve as a [JsString] object.
     * @return A [JsHtmlElement] representing the found HTML element, or `null` if not found.
     */
    fun namedItem(name: JsString): JsHtmlElement =
        JsHtmlElement.syntax(ChainOperation(this, InvocationOperation("namedItem", name)))

    /**
     * Returns the first element in the collection that has the specified `id` or `name` attribute.
     * This is a convenience overload for [namedItem] that accepts a Kotlin [String].
     * @param name The `id` or `name` of the element to retrieve as a Kotlin [String].
     * @return A [JsHtmlElement] representing the found HTML element, or `null` if not found.
     */
    fun namedItem(name: String): JsHtmlElement = namedItem(name.js)

    companion object
}