package net.asere.kthot.js.dsl.dom.type.core.node

import net.asere.kthot.js.dsl.dom.type.core.event.target.JsEventTarget
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents a single node in the DOM tree (Element, Text, Comment, etc.).
 * Provides methods for navigating and manipulating the tree structure.
 */
interface JsNode : JsEventTarget {

    val nodeType: JsNumber get() = JsNumber.syntax(ChainOperation(this, "nodeType"))
    val nodeName: JsString get() = JsString.syntax(ChainOperation(this, "nodeName"))
    val ownerDocument: JsObject get() = JsObject.syntax(ChainOperation(this, "ownerDocument")) // Returns Document object
    val parentNode: JsNode get() = JsNode.syntax(ChainOperation(this, "parentNode"))
    val firstChild: JsNode get() = JsNode.syntax(ChainOperation(this, "firstChild"))
    val lastChild: JsNode get() = JsNode.syntax(ChainOperation(this, "lastChild"))
    val nextSibling: JsNode get() = JsNode.syntax(ChainOperation(this, "nextSibling"))
    val previousSibling: JsNode get() = JsNode.syntax(ChainOperation(this, "previousSibling"))
    val childNodes: JsObject get() = JsObject.syntax(ChainOperation(this, "childNodes")) // Returns NodeList

    /**
     * Adds a node to the end of the list of children of a specified parent node.
     * Corresponds to `node.appendChild(child)`.
     * @param child The [JsNode] to append.
     * @return The appended [JsNode].
     */
    fun appendChild(child: JsNode): JsNode =
        JsNode.syntax(ChainOperation(this, InvocationOperation("appendChild", child)))

    /**
     * Removes a child node from the DOM and returns the removed node.
     * Corresponds to `node.removeChild(child)`.
     * @param child The [JsNode] to remove.
     * @return The removed [JsNode].
     */
    fun removeChild(child: JsNode): JsNode =
        JsNode.syntax(ChainOperation(this, InvocationOperation("removeChild", child)))

    /**
     * Inserts a node before the reference node as a child of a specified parent node.
     * Corresponds to `node.insertBefore(newNode, referenceNode)`.
     * @param newNode The [JsNode] to insert.
     * @param referenceNode The [JsNode] before which newNode is inserted (or null).
     * @return The inserted [JsNode].
     */
    fun insertBefore(newNode: JsNode, referenceNode: JsNode): JsNode =
        JsNode.syntax(ChainOperation(this, InvocationOperation("insertBefore", newNode, referenceNode)))

    /**
     * Replaces a child node within the given node with a new child.
     * Corresponds to `node.replaceChild(newChild, oldChild)`.
     * @param newChild The [JsNode] to replace the existing child.
     * @param oldChild The [JsNode] to be replaced.
     * @return The replaced [JsNode] (oldChild).
     */
    fun replaceChild(newChild: JsNode, oldChild: JsNode): JsNode =
        JsNode.syntax(ChainOperation(this, InvocationOperation("replaceChild", newChild, oldChild)))

    /**
     * Checks if a node is a descendant of the given node.
     * Corresponds to `node.contains(otherNode)`.
     * @param otherNode The potential descendant [JsNode].
     * @return A [JsObject] (Boolean).
     */
    fun contains(otherNode: JsNode): JsObject =
        JsObject.syntax(ChainOperation(this, InvocationOperation("contains", otherNode)))

    companion object
}