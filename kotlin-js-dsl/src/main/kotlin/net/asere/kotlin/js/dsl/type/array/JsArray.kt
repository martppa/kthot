package net.asere.kotlin.js.dsl.type.array

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.AccessOperation
import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.type.lambda.l2.JsLambda2
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.JsNumberSyntax
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript array.
 * This interface provides methods and properties for manipulating arrays in JavaScript.
 *
 * @param T The type of [JsValue] that the array holds.
 */
interface JsArray<T : JsValue> : JsObject {

    companion object

    val refBuilder: (JsElement) -> T get() = { throw IllegalStateException("Builder not set!") }

    /**
     * Returns the element at the specified index in the array.
     *
     * In JavaScript, this corresponds to `array[index]`.
     * @param index The zero-based index of the element to retrieve as a [JsNumber] object.
     * @return A [T] reference to the element at the specified index.
     */
    fun getByIndex(index: JsNumber): T = refBuilder(AccessOperation(this, index))

    /**
     * Returns the number of elements in the array.
     *
     * In JavaScript, this corresponds to `array.length`.
     * @return A [JsNumber] object representing the length of the array.
     */
    fun getLength(): JsNumber = JsNumberSyntax(ChainOperation(this, "length"))

    /**
     * Adds one or more elements to the end of an array and returns the new length of the array.
     *
     * In JavaScript, this corresponds to `array.push(element1, element2, ...)`.
     * @param elements A list of [T] (elements) to add to the array.
     * @return A [JsNumber] object representing the new length of the array.
     */
    fun push(vararg elements: T): JsNumber {
        return JsNumberSyntax(ChainOperation(this, InvocationOperation("push", *elements)))
    }

    /**
     * Removes the last element from an array and returns that element.
     *
     * In JavaScript, this corresponds to `array.pop()`.
     * @return A [T] reference to the removed element.
     */
    fun pop(): T = refBuilder(ChainOperation(this, InvocationOperation("pop")))

    /**
     * Removes the first element from an array and returns that element.
     *
     * In JavaScript, this corresponds to `array.shift()`.
     * @return A [JsNumberSyntax] object representing the removed element.
     */
    fun shift(): JsNumberSyntax = JsNumberSyntax(ChainOperation(this, InvocationOperation("shift")))

    /**
     * Adds one or more elements to the beginning of an array and returns the new length of the array.
     *
     * In JavaScript, this corresponds to `array.unshift(element1, element2, ...)`.
     * @param elements A list of [JsValue] objects (elements) to add to the beginning of the array.
     * @return A [JsNumberSyntax] object representing the new length of the array.
     */
    fun unshift(vararg elements: T): JsNumberSyntax {
        return JsNumberSyntax(ChainOperation(this, InvocationOperation("unshift", *elements)))
    }

    /**
     * Executes a provided function once for each array element.
     *
     * In JavaScript, this corresponds to `array.forEach(callback)`.
     * @param lambda A [JsLambda1] representing the JavaScript function to execute for each element.
     * The function typically receives the current element as its first argument.
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun forEach(lambda: JsLambda1<T>): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("forEach", lambda)))

    /**
     * Creates a new array populated with the results of calling a provided function on every element in the calling array.
     *
     * In JavaScript, this corresponds to `array.map(callback)`.
     * @param lambda A [JsLambda1] representing the JavaScript function to execute for each element.
     * The function typically receives the current element as its first argument.
     * @return A [JsSyntax] object representing the JavaScript method call that returns a new array.
     */
    fun map(lambda: JsLambda1<T>): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("map", lambda)))

    /**
     * Creates a new array populated with the results of calling a provided function on every element in the calling array,
     * with access to the index of the element.
     *
     * In JavaScript, this corresponds to `array.map(callback)`. The callback receives `(element, index)`.
     * @param lambda A [JsLambda2] representing the JavaScript function to execute for each element.
     * The function typically receives the current element as its first argument and its index as the second.
     * @return A [JsSyntax] object representing the JavaScript method call that returns a new array.
     */
    fun mapIndexed(lambda: JsLambda2<T, JsNumber>): JsSyntax =
        JsSyntax(ChainOperation(this, InvocationOperation("map", lambda)))
}