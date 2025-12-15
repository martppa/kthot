package net.asere.kthot.js.dsl.dom.type.core.node.list

import net.asere.kthot.js.dsl.dom.type.core.node.JsNode
import net.asere.kthot.js.dsl.dom.type.core.node.syntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.syntax.operational.access.operation.AccessOperation
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.js
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax

/**
 * Represents the JavaScript DOM NodeList interface.
 * This is an ordered, array-like collection of nodes (Element, Text, Comment, etc.).
 * It is often used for lists of children nodes and the results of [querySelectorAll].
 *
 * This interface includes modern iteration methods like [forEach].
 */
interface JsNodeList : JsObject {

    /**
     * Returns the number of nodes in the collection.
     * In JavaScript, this corresponds to `collection.length`.
     */
    val length: JsNumber get() = JsNumber.syntax(ChainOperation(this, "length"))

    /**
     * Allows accessing a node in the collection using the Kotlin array-access operator `[]`.
     * In JavaScript, this corresponds to `collection[index]`.
     * @param index The zero-based index of the node to retrieve as a [JsNumber] object.
     * @return A [JsNode] representing the DOM node at the specified index.
     */
    operator fun get(index: JsNumber): JsNode = JsNode.syntax(AccessOperation(this, index))

    /**
     * Allows accessing a node in the collection using the Kotlin array-access operator `[]`.
     * This is a convenience overload for [get] that accepts a Kotlin [Int].
     * @param index The zero-based index of the node to retrieve as a Kotlin [Int].
     * @return A [JsNode] representing the DOM node at the specified index.
     */
    operator fun get(index: Int): JsNode = get(index.js)

    /**
     * Returns a node in the collection using the `item()` method.
     * In JavaScript, this corresponds to `collection.item(index)`.
     * @param index The zero-based index of the node to retrieve as a [JsNumber] object.
     * @return A [JsNode] representing the DOM node at the specified index.
     */
    fun item(index: JsNumber): JsNode =
        JsNode.syntax(ChainOperation(this, InvocationOperation("item", index)))

    /**
     * Returns a node in the collection using the `item()` method.
     * This is a convenience overload for [item] that accepts a Kotlin [Int].
     * @param index The zero-based index of the node to retrieve as a Kotlin [Int].
     * @return A [JsNode] representing the DOM node at the specified index.
     */
    fun item(index: Int): JsNode = item(index.js)

    /**
     * Executes a provided function once for each node in the collection.
     * This uses a standard Kotlin lambda for clean, readable syntax.
     * Corresponds to `collection.forEach(callback)`.
     *
     * @param handler The Kotlin lambda (`JsScope.(JsNode) -> Unit`) executed for each node.
     * The first argument passed to the lambda is the current [JsNode].
     * @return A [JsSyntax] object representing the JavaScript method call.
     */
    fun forEach(handler: JsScope.(JsNode) -> Unit): JsSyntax =
        JsSyntax(
            ChainOperation(
                leftHand = this,
                rightHand = InvocationOperation(
                    leftSideElement = "forEach",
                    handler.js(JsNode::syntax)
                )
            )
        )
    fun forEach(lambda: JsLambda1<JsNode>): JsSyntax = JsSyntax(ChainOperation(this, InvocationOperation("forEach", lambda)))

    /**
     * Returns a new `Iterator` object that contains the `[index, node]` pairs for each node in the collection.
     * Corresponds to `collection.entries()`.
     * @return A [JsObject] object representing the JavaScript method call that returns an Iterator.
     */
    fun entries(): JsObject = JsObject.syntax(ChainOperation(this, InvocationOperation("entries")))

    /**
     * Returns a new `Iterator` object that contains the keys (indices) for each node in the collection.
     * Corresponds to `collection.keys()`.
     * @return A [JsObject] object representing the JavaScript method call that returns an Iterator.
     */
    fun keys(): JsObject = JsObject.syntax(ChainOperation(this, InvocationOperation("keys")))

    /**
     * Returns a new `Iterator` object that contains the values (nodes) for each node in the collection.
     * Corresponds to `collection.values()`.
     * @return A [JsObject] object representing the JavaScript method call that returns an Iterator.
     */
    fun values(): JsObject = JsObject.syntax(ChainOperation(this, InvocationOperation("values")))

    companion object
}