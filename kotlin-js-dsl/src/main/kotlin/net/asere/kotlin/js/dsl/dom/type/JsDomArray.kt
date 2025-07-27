package net.asere.kotlin.js.dsl.dom.type

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsDomObjectSyntax
import net.asere.kotlin.js.dsl.syntax.value.JsNumberSyntax
import net.asere.kotlin.js.dsl.types.reference.lambda.JsLambda1Ref
import net.asere.kotlin.js.dsl.types.type.JsNumber
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.JsString
import net.asere.kotlin.js.dsl.types.type.js

/**
 * Represents a JavaScript DOM collection, such as `NodeList` or `HTMLCollection`.
 * These collections are array-like objects that contain DOM elements.
 *
 * This interface provides properties and methods for accessing and iterating over the elements
 * within the collection.
 */
interface JsDomArray : JsObject {
    /**
     * Returns the number of elements in the collection as a [JsNumber] object.
     *
     * In JavaScript, this corresponds to `collection.length`.
     */
    val length: JsNumber get() = JsNumberSyntax("${this}.length")

    /**
     * Allows accessing an element in the collection using the Kotlin array-access operator `[]`.
     *
     * In JavaScript, this corresponds to `collection[index]`.
     * @param index The zero-based index of the element to retrieve as a [JsNumber] object.
     * @return A [JsDomObject] representing the DOM element at the specified index.
     */
    operator fun get(index: JsNumber): JsDomObject = JsDomObjectSyntax("${this}[$index]")

    /**
     * Allows accessing an element in the collection using the Kotlin array-access operator `[]`.
     * This is a convenience overload for [get] that accepts a Kotlin [Int].
     *
     * @param index The zero-based index of the element to retrieve as a Kotlin [Int].
     * @return A [JsDomObject] representing the DOM element at the specified index.
     */
    operator fun get(index: Int): JsDomObject = get(index.js)

    /**
     * Returns an element in the collection using the `item()` method.
     *
     * In JavaScript, this corresponds to `collection.item(index)`.
     * @param index The zero-based index of the element to retrieve as a [JsNumber] object.
     * @return A [JsDomObject] representing the DOM element at the specified index.
     */
    fun getItem(index: JsNumber): JsDomObject = JsDomObjectSyntax("${this}.item($index)")

    /**
     * Returns an element in the collection using the `item()` method.
     * This is a convenience overload for [getItem] that accepts a Kotlin [Int].
     *
     * @param index The zero-based index of the element to retrieve as a Kotlin [Int].
     * @return A [JsDomObject] representing the DOM element at the specified index.
     */
    fun getItem(index: Int): JsDomObject = getItem(index.js)

    /**
     * Returns the first element in the collection that has the specified `id` or `name` attribute.
     * This method is typically available on `HTMLCollection`s.
     *
     * In JavaScript, this corresponds to `collection.namedItem(name)`.
     * @param name The `id` or `name` of the element to retrieve as a [JsString] object.
     * @return A [JsDomObject] representing the found DOM element, or `null` if not found.
     */
    fun namedItem(name: JsString): JsDomObject = JsDomObjectSyntax("${this}.namedItem($name)")

    /**
     * Returns the first element in the collection that has the specified `id` or `name` attribute.
     * This is a convenience overload for [namedItem] that accepts a Kotlin [String].
     *
     * @param name The `id` or `name` of the element to retrieve as a Kotlin [String].
     * @return A [JsDomObject] representing the found DOM element, or `null` if not found.
     */
    fun namedItem(name: String): JsDomObject = namedItem(name.js)

    /**
     * Executes a provided function once for each element in the `NodeList` (or similar iterable collection).
     *
     * In JavaScript, this corresponds to `collection.forEach(callback)`.
     * @param callback A [JsLambda1Ref] representing the JavaScript function to execute for each element.
     * The function typically receives the current element as its first argument.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun forEach(callback: JsLambda1Ref<JsDomObject>): JsSyntax = JsSyntax("${this}.forEach($callback)")

    /**
     * Returns a new `Iterator` object that contains the `[index, element]` pairs for each element in the collection.
     *
     * In JavaScript, this corresponds to `collection.entries()`.
     * @return A [JsSyntax] object representing the JavaScript method call that returns an Iterator.
     */
    fun entries(): JsSyntax = JsSyntax("${this}.entries()")

    /**
     * Returns a new `Iterator` object that contains the keys (indices) for each element in the collection.
     *
     * In JavaScript, this corresponds to `collection.keys()`.
     * @return A [JsSyntax] object representing the JavaScript method call that returns an Iterator.
     */
    fun keys(): JsSyntax = JsSyntax("${this}.keys()")

    /**
     * Returns a new `Iterator` object that contains the values (elements) for each element in the collection.
     *
     * In JavaScript, this corresponds to `collection.values()`.
     * @return A [JsSyntax] object representing the JavaScript method call that returns an Iterator.
     */
    fun values(): JsSyntax = JsSyntax("${this}.values()")

    companion object
}